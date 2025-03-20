//page load lên thì gọi start, lấy data
start();

function start() {
  getTables(renderTables);
}

//bam submit ko cho form gui request di
const form = document.getElementById("formData");
form.addEventListener("submit", function (event) {
  event.preventDefault();
});

// Add a click event listener to show the button
document.getElementById("AddTrigger").addEventListener("click", function () {
  const add = document.getElementById("changeBtn");
  add.innerHTML = `<button id="Add" type="button" class="btn btn-primary">Add</button>`;
  const label = document.getElementById("exampleModalLabel");
  label.textContent = "Add Employee";
  var usernamePasswordFields = document.getElementById("userName");
  var passwordFields = document.getElementById("password");
  usernamePasswordFields.style.visibility  = "visible";
  passwordFields.style.visibility  = "visible";
  //new event
  document.querySelector("#Add").onclick = function () {
    const formData = new FormData(document.getElementById("formData"));
    // formData.delete("tableID"); // add thi phai co dong nay
    const data = Object.fromEntries(formData);
    // console.log(formData);

    // console.log(JSON.stringify(data));
    addTable(formData, renderTable(data));
  };
});

// bat su kien click update de hien modal update
function getTableToUpdate(id) {
  //get table by id and render into modal
  getTable(id, renderForm);

  //show update button and label on modal
  const update = document.getElementById("changeBtn");
  update.innerHTML = `<button id="Update" type="button" class="btn btn-primary">Update</button>`;
  const label = document.getElementById("exampleModalLabel");
  label.textContent = "Update Employee";
  var usernamePasswordFields = document.getElementById("userName");
  var passwordFields = document.getElementById("password");
  usernamePasswordFields.style.visibility  = "hidden";
  passwordFields.style.visibility  = "hidden";
  //them su kien cho nut update
  document.querySelector("#Update").onclick = function () {
    const formData = new FormData(document.getElementById("formData"));
    const data = Object.fromEntries(formData);

    console.log(data);
    updateTable(formData, reRenderTable);

  };
}

//bat su kien click 1 trong 3 nut empty, reserved, full
function updateTableStatusOnClick(id) {
  getTable(id, function (table) {
    deleteTable(id);
  });
}

// bat su kien click update de hien modal update
// function getTableToUpdate(id){
//   const update = document.getElementById("changeBtn"); update.innerHTML = `<button id="Update" type="button" class="btn btn-primary">Update</button>`;
//   getTable(id, renderForm);
// }

//send request get all tables
function getTables(callback) {
  var customerAPI = "http://localhost:8088/hcr/manager/getall";
  fetch(customerAPI)
    .then(function (response) {
      return response.json();
    })
    .then(callback);

}

//send request get table by id
function getTable(id, callback) {
  var customerAPI = "http://localhost:8088/hcr/manager/employee/" +id;
  var options = {
    method: "GET",
    headers: {
      "Content-type": "application/json",
    },
  };
  fetch(customerAPI, options)
    .then(function (response) {
      return response.json();
    })
    .then(callback);
}

// send request add table
function addTable(data, callback) {
  var customerAPI = "http://localhost:8088/hcr/manager/addEmp";
  var options = {
    method: "POST",
    headers: {
      // 'Content-type': 'application/x-www-form-urlencoded',
      // 'Accept': 'application/json'
    },
    body: data
  };

  fetch(customerAPI, options)
    .then(function (response) {
      //  response.json();
      // console.log(response.json());
      console.log(response.status);
      if (response.status == 200) {
        document
          .getElementById("addresult")
          .setAttribute("style", "display: block;");
        setTimeout(function () {
          document.getElementById("addresult").style.display = "none";
        }, 2000);


        return response.json();
      }
    })
    .then(callback)
    .catch(function (error) {
      console.log(error);
    });
}

// send request update table
function updateTable(data, callback) {
  var customerAPI = "http://localhost:8088/hcr/manager/updateEmp";
  var options = {
    method: "PUT",
    headers: {
     // "Content-type": "application/json",
    },
    body: data
    // body: data
  };
  console.log(JSON.stringify(data));
  fetch(customerAPI, options)
    .then(function (response) {
      console.log(response.status);
      if (response.status == 200) {
        document
          .getElementById("addresult")
          .setAttribute("style", "display: block;");
        setTimeout(function () {
          document.getElementById("addresult").style.display = "none";
        }, 2000);
        return response.json();
      }
    })
    .then(callback)
    .catch(function (error) {
      console.log(error);
    });
}

// send request update table
function updateTableStatus(table, callback) {
  var customerAPI = "http://localhost:8088/hcr/manager/ban";
  var options = {
    method: "PUT",
    headers: {
      "Content-type": "application/json",
    },
    body: JSON.stringify(table),
  };

  fetch(customerAPI, options)
    .then(function (response) {
      console.log(response.status);
      return response.json();
    })
    .then(callback)
    .catch(function (error) {
      console.log(error);
    });
}

//call api to delete a table by id
function deleteTable(id) {
  var customerAPI = "http://localhost:8088/hcr/manager/ban";
  var options = {
    method: "DELETE",
    headers: {
      "Content-type": "application/json",
    },
  };
  fetch(customerAPI + "/" + id, options)
    .then(function (response) {
      response.json();
    })
    .then(function () {
      var table = document.querySelector(".table-item-" + id);
      reRenderTable(table);
    });
}

function renderTables(tables) {
  console.log(tables);
  var table = document.querySelector("#tbody");
  var htmls = tables.map(function (table, index) {
    console.log(table);
    // let images = "";
    // if(table.image){
    //   (table.image).split(';').forEach(element => {
    //     images += `<img src="/img/${element}" alt="Image">`;
    //   });
    // }

    // var privacy;
    // var status;

    // if (table.status == 1) status = `<div style="color:green;">Empty</div>`;
    // else if (table.status == 2)
    //   status = `<div style="color:orange;">Reserved</div>`;
    // else if (table.status == 3) status = `<div style="color:red;">Full</div>`;

    // if (table.privacy == 0) privacy = `<div style="color:green;">Public</div>`;
    // else privacy = `<div style="color:red;">Private</div>`;
    var btnHtml=`<div onclick="updateTableStatusOnClick(${table.personID})" class="btn btn-success">Ban</div>`;
    if (table.status== 0){
        btnHtml=`<div onclick="updateTableStatusOnClick(${table.personID})" class="btn btn-danger">UnBan</div>`;
    }
    return `
          <tr class="table-item-${table.personID}" >
      <td>${table.personID}</td>
      <td>${table.firstName} ${table.lastName}</td>
      <td>${table.address}</td>
      <td>${table.phoneNumber}</td>
      <td>${table.gender ? "Male" : "Female"}</td>
      <td>${table.email}</td>
      <td>${table.salary}</td>
      <td>${table.department}</td>
      <td>
        <div class="container">
          <button onclick="getTableToUpdate(${table.personID})" type="button" class="btn btn-outline-dark" data-bs-toggle="modal" data-bs-target="#exampleModal">
            <i class="fa-regular fa-pen-to-square"></i>
          </button>
            ${btnHtml}
        </div>
      </td>
    </tr>
    `;
  });
  table.innerHTML += htmls.join("");
}

//
function renderTable(table) {
  if (table != null) {
    var tbody = document.querySelector("#tbody");
    // let images = "";
    // if(table.image){
    //   (table.image).split(';').forEach(element => {
    //     images += `<img src="/img/${element}" alt="Image">`;
    //   });
    // }
    var btnHtml=`<div onclick="updateTableStatusOnClick(${table.personID})" class="btn btn-success">Ban</div>`;
    if (table.status== 0){
      btnHtml=`<div onclick="updateTableStatusOnClick(${table.personID})" class="btn btn-danger">UnBan</div>`;
    }
    tbody.innerHTML += `
          <tr class="table-item-${table.personID}" >
      <td>${table.personID}</td>
      <td>${table.firstName} ${table.lastName}</td>
      <td>${table.address}</td>
      <td>${table.phoneNumber}</td>
      <td>${table.gender ? "Male" : "Female"}</td>
      <td>${table.email}</td>
      <td>${table.salary}</td>
      <td>${table.department}</td>
      <td>
        <div class="container">
          <button onclick="getTableToUpdate(${table.personID})" type="button" class="btn btn-outline-dark" data-bs-toggle="modal" data-bs-target="#exampleModal">
            <i class="fa-regular fa-pen-to-square"></i>
          </button>
          ${btnHtml}
        </div>
      </td>
    </tr>
          `;
  }
}

function reRenderTable(table) {
  console.log(table);
  if (table !== null) {
    var id=table.personID;
    var updateItem = document.querySelector(".table-item-" + id);
    if (updateItem) {
      var btnHtml=`<div onclick="updateTableStatusOnClick(${table.personID})" class="btn btn-success">Ban</div>`;
      if (table.status== 1){
        btnHtml=`<div onclick="updateTableStatusOnClick(${table.personID})" class="btn btn-danger">UnBan</div>`;
      }
      updateItem.innerHTML = `
          <tr class="table-item-${table.personID}" >
      <td>${table.personID}</td>
      <td>${table.firstName} ${table.lastName}</td>
      <td>${table.address}</td>
      <td>${table.phoneNumber}</td>
      <td>${table.gender ? "Male" : "Female"}</td>
      <td>${table.email}</td>
      <td>${table.salary}</td>
      <td>${table.department}</td>
      <td>
        <div class="container">
          <button onclick="getTableToUpdate(${table.personID})" type="button" class="btn btn-outline-dark" data-bs-toggle="modal" data-bs-target="#exampleModal">
            <i class="fa-regular fa-pen-to-square"></i>
          </button>
          ${btnHtml}
        </div>
      </td>
    </tr>
            `;
    }
  }
}

// In du lieu table ra modal de update
function renderForm(table) {
  document.querySelector('input[name="personID"]').value = table.personID;
  document.querySelector('input[name="firstName"]').value = table.firstName;
  document.querySelector('input[name="lastName"]').value = table.lastName;
  document.querySelector('input[name="address"]').value = table.address;
  document.querySelector('input[name="phoneNumber"]').value = table.phoneNumber;
  if(table.gender==true) document.querySelector('input[id="Male"]').checked=true
  else if (table.gender==false) document.querySelector('input[id="Female"]').checked=true;
  document.querySelector('input[name="email"]').value = table.email;
  document.querySelector('input[name="salary"]').value = table.salary;
  document.querySelector('input[name="department"]').value = table.department;
  document.querySelector('input[name="contract"]').value = table.contract;



}
