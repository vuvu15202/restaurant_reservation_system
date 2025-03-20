//Set Content-Type and Accept headers
//const headers = new Headers();
//headers.append('Content-Type', 'application/json');
//headers.append('Accept', 'application/json');

// HTTP request options
//const options = {
// method: 'POST',
//  headers: headers,
//  body: JSON.stringify(requestData)
// };

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
document.getElementById("OrderTrigger").addEventListener("click", function () {

  getTable( renderForm);

});

// bat su kien click update de hien modal update
// function getTableToUpdate(id) {
//   console.log(id);

//   //get table by id and render into modal
//   getTable(id, renderForm);

//   //show update button and label on modal
//   const update = document.getElementById("changeBtn");
//   update.innerHTML = `<button id="Update" type="button" class="btn btn-primary">Update</button>`;
//   const label = document.getElementById("exampleModalLabel");
//   label.textContent = "Update Table";

//   //them su kien cho nut update
//   document.querySelector("#Update").onclick = function () {
//     const formData = new FormData(document.getElementById("formData"));
//     const data = Object.fromEntries(formData);
//     console.log(data);

//     updateTable(data, reRenderTable);
//   };
// }

//bat su kien click 1 trong 3 nut empty, reserved, full
function updateTableStatusOnClick(id, status) {
  getTable(id, function (table) {
    table.status = status;
    updateTableStatus(table, reRenderTable);
  });
}

// document.querySelector('input[name="quantity"]').addEventListener("change", function (event) { console.log(event.target.id +"d" + event.target.value);
//   updateTable(event.target.id , event.target.value);
// });
// const quantityInputs = document.querySelectorAll('input[name="quantity"]');
// quantityInputs.forEach(input => {
//   input.addEventListener('change', function(event) {
//     updateTable(event.target.id , event.target.value);
//   });
// });

// bat su kien click update de hien modal update
// function getTableToUpdate(id){
//   const update = document.getElementById("changeBtn"); update.innerHTML = `<button id="Update" type="button" class="btn btn-primary">Update</button>`;
//   getTable(id, renderForm);
// }

//send request get all tables
function getTables(callback) {
  var customerAPI = "http://localhost:8088/hcr/cart/carts";
  fetch(customerAPI)
    .then(function (response) {
      return response.json();
    })
    .then(callback);
}

//send request get table by id
function getTable(callback) {
  var customerAPI = "http://localhost:8088/hcr/customer/profile";
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
  var customerAPI = "http://localhost:8088/hcr/employee/table";
  var options = {
    method: "POST",
    headers: {
      // 'Content-type': 'multipart/form-data',
      // 'Accept': 'application/json'
    },
    // body: JSON.stringify(data)
    body: data,
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
function updateTable(id) {
  var input = document.getElementById(id);
  var customerAPI = "http://localhost:8088/hcr/cart/updatecart";
  var options = {
    method: "PUT",
    headers: {
      "Content-type": "application/json",
    },
    body: JSON.stringify({ menuDTO: { menuID: id }, quantity: input.value }),
    // body: data
  };

  fetch(customerAPI, options)
    .then(function (response) {
      console.log(response.status);
      if (response.status == 200) {
        // document
        //   .getElementById("addresult")
        //   .setAttribute("style", "display: block;");
        // setTimeout(function () {
        //   document.getElementById("addresult").style.display = "none";
        // }, 2000);
      }
      return response.json();
    })
    .then(function (response) {
      console.log(response);
      if (response.quantity == 0) {
        var removeItem = document.querySelector(
          ".cart-item-" + response.menuDTO.menuID
        );
        if (removeItem) {
          removeItem.remove();
        }
      }
    })
    .catch(function (error) {
      console.log(error);
    });
}

// send request update table
function updateTableStatus(table, callback) {
  var customerAPI = "http://localhost:8088/hcr/employee/table";
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
function deleteItem(id) {
  var customerAPI = "http://localhost:8088/hcr/cart/deletecart";
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
      var removeItem = document.querySelector(".cart-item-" + id);
      if (removeItem) {
        removeItem.remove();
      }
    });
}
// <img
//           src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-shopping-carts/img5.webp"
//           class="img-fluid rounded-3" alt="Cotton T-shirt">
//       </div>

function renderTables(tables) {
  var table = document.querySelector("#carts");
  var total = document.querySelector("#total");
  total.innerHTML = tables.totalMoney;
  var htmls = tables.items.map(function (table) {
    console.log(table);

    var image = `<img src="/hcr/img/${table.menuDTO.image}" alt="Image" style="max-width: 100%; max-height: 100%;"  class="img-fluid rounded-3"> `;
    return `
          <div class="cart-item-${table.menuDTO.menuID}">
          <hr class="my-4">
          <div class="row mb-4 d-flex justify-content-between align-items-center">
            <div class="col-md-2 col-lg-2 col-xl-2">
            ${image}
            </div>
            <div class="col-md-3 col-lg-3 col-xl-3">
              <h6 class="text-muted">dish</h6>
              <h6 class="text-black mb-0">${table.menuDTO.dishName}</h6>
            </div>
            <div class="col-md-4 col-lg-3 col-xl-3 d-flex">
              <button class="btn btn-link px-2"
                onclick="this.parentNode.querySelector('input[type=number]').stepDown()">
                <i class="fas fa-minus"></i>
              </button>

              <input onchange="updateTable(${table.menuDTO.menuID})" id="${table.menuDTO.menuID}" min="0" name="quantity" value="${table.quantity}" type="number"
                />

              <button class="btn btn-link px-2"
                onclick="this.parentNode.querySelector('input[type=number]').stepUp()">
                <i class="fas fa-plus"></i>
              </button>
            </div>
            <div class="col-md-2 col-lg-2 col-xl-2 offset-lg-1">
              <h6 class="mb-0">${table.price}</h6>
            </div>
            <div class="col-md-1 col-lg-1 col-xl-1 text-end">
              <a onclick="deleteItem(${table.menuDTO.menuID})" class="text-muted"><i class="fas fa-times"></i></a>
            </div>
          </div></div>
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
    var privacy;
    var status;

    if (table.status == 1) status = `<div style="color:green;">Empty</div>`;
    else if (table.status == 2)
      status = `<div style="color:orange;">Reserved</div>`;
    else if (table.status == 3) status = `<div style="color:red;">Full</div>`;

    if (table.privacy == 0) privacy = `<div style="color:green;">Public</div>`;
    else privacy = `<div style="color:red;">Private</div>`;

    tbody.innerHTML += `
          <tr class="table-item-${table.tableID}">
              <td>${table.tableID} 
              <button onclick="getTableToUpdate(${table.tableID})" type="button" class="btn btn-outline-dark" data-bs-toggle="modal" data-bs-target="#exampleModal">
                <i class="fa-regular fa-pen-to-square"></i>
              </button>
            </td>
              <td>${table.chairNumber}</td>
              <td>${table.floorNo}</td>
              <td>${privacy}</td>
              <td>${status}</td>
              <td>
                <div class="container">
                  <div onclick="updateTableStatusOnClick(${table.tableID},1)" class="btn btn-success">Empty</div>
                  <div onclick="updateTableStatusOnClick(${table.tableID},2)" class="btn btn-warning">Reserved</div>
                  <div onclick="updateTableStatusOnClick(${table.tableID},3)" class="btn btn-danger">Full</div>
                </div>
              </td>
            </tr>
          `;
  }
}

function reRenderTable(table) {
  if (table !== null) {
    var privacy;
    var status;
    if (table.status == 1) status = `<div style="color:green;">Empty</div>`;
    else if (table.status == 2)
      status = `<div style="color:orange;">Reserved</div>`;
    else if (table.status == 3) status = `<div style="color:red;">Full</div>`;
    if (table.privacy == 0) privacy = `<div style="color:green;">Public</div>`;
    else privacy = `<div style="color:red;">Private</div>`;

    var updateItem = document.querySelector(".table-item-" + table.tableID);
    if (updateItem) {
      updateItem.innerHTML = `
              <td>${table.tableID} 
                <button onclick="getTableToUpdate(${table.tableID})" type="button" class="btn btn-outline-dark" data-bs-toggle="modal" data-bs-target="#exampleModal">
                  <i class="fa-regular fa-pen-to-square"></i>
                </button>
              </td>
              <td>${table.chairNumber}</td>
              <td>${table.floorNo}</td>
              <td>${privacy}</td>
              <td>${status}</td>
              <td>
                <div class="container">
                <div onclick="updateTableStatusOnClick(${table.tableID},1)" class="btn btn-success">Empty</div>
                <div onclick="updateTableStatusOnClick(${table.tableID},2)" class="btn btn-warning">Reserved</div>
                <div onclick="updateTableStatusOnClick(${table.tableID},3)" class="btn btn-danger">Full</div>
                </div>
              </td>
            `;
    }
  }
}

// In du lieu table ra modal de update
function renderForm(table) {
  document.querySelector('input[name="customerID"]').value = table.personID;
  document.querySelector('input[name="firstName"]').value = table.firstName;
  document.querySelector('input[name="lastName"]').value = table.lastName;
  document.querySelector('input[name="phoneNumber"]').value = table.phoneNumber;
  document.querySelector('input[name="email"]').value = table.email;
  document.querySelector('input[name="address"]').value = table.address;

}




//validate

function register() {
  var emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
  var phoneRegex = /^[0-9]{10}$/;
  var customerID = document.getElementById("customerID").value;
  var firstName = document.getElementById("firstName").value;
  var lastName = document.getElementById("lastName").value;
  var email = document.getElementById("email").value;
  var phone = document.getElementById("phone").value;
  var address = document.getElementById("address").value;
  var txtDistrict = document.getElementById("txtDistrict").value;
  var txtCity = document.getElementById("txtCity").value;
  validateName(firstName, lastName);
  validateEmail(email);
  validateAddress(address);
  validatePhone(phone);

  //Email
  if (email === "") {
    document.getElementById("errorMessageEmail").textContent =
      "Email cannot be blank";
  }
  if (!emailRegex.test(email)) {
    email = "";
    document.getElementById("errorMessageEmail").textContent =
      "Invalid email (vv@vv.vv)";
  }
  if (email != "") {
    const data = {
      email: email,
    };
    var requestOptions = {
      method: "POST",
      headers: {
        "Content-type": "application/json",
      },
      body: JSON.stringify(data),
    };
    fetch("http://localhost:8088/hcr/person/email", requestOptions).then(
      function (response) {
        if (response.status == 200) {
          // email = "";
          // document.getElementById("errorMessageEmail").textContent =
          //   "Email has been used!";
          document.getElementById("errorMessageEmail").textContent = "";
          return response.json();
        } else {
          document.getElementById("errorMessageEmail").textContent = "";
        }
      }
    );
  }

  //Name
  if (firstName === "" && lastName != "") {
    document.getElementById("errorMessageFirstname").textContent =
      "First name cannot be blank";
    document.getElementById("errorMessageLastname").textContent = "";
  }
  if (firstName != "" && lastName === "") {
    document.getElementById("errorMessageFirstname").textContent = "";
    document.getElementById("errorMessageLastname").textContent =
      "Last name cannot be blank";
  }
  if (firstName === "" && lastName === "") {
    document.getElementById("errorMessageFirstname").textContent =
      "First name cannot be blank";
    document.getElementById("errorMessageLastname").textContent =
      "Last name cannot be blank";
  }
  if (firstName != "" && lastName != "") {
    document.getElementById("errorMessageFirstname").textContent = "";
    document.getElementById("errorMessageLastname").textContent = "";
  }

  //Address
  if (address === "" || txtDistrict === "" || txtCity === "" ) {
    document.getElementById("errorMessageAddress").textContent =
      "Address cannot be blank";
  }
  if (address != "" || txtDistrict != "" || txtCity != "" ) {
    document.getElementById("errorMessageAddress").textContent = "";
  }

  if (txtDistrict !== "Huyện Thạch Thất" || txtCity !== "Hà Nội" ) {
    address = "";
    document.getElementById("errorMessageAddress").textContent =
      "Sorry, We curently cannot support delivery at this location!";
  }else{
    document.getElementById("errorMessageAddress").textContent = "";
  }

  //Phone
  if (phone === "") {
    document.getElementById("errorMessagePhone").textContent =
      "Phone cannot be blank";
  }
  if (!phoneRegex.test(phone)) {
    phone = "";
    document.getElementById("errorMessagePhone").textContent =
      "Invalid phone (10 numbers)";
  } else {
    document.getElementById("errorMessagePhone").textContent = "";
  }

  if (
    firstName != "" &&
    lastName != "" &&
    phone != "" &&
    address != "" &&
    email != ""
  ) {
    const data = {
      customerID: customerID,
      firstName: firstName,
      lastName: lastName,
      address: txtCity +", "+ txtDistrict +", "+ address,
      email: email,
      phoneNumber: phone,
      gender: 1,
    }; console.log(JSON.stringify(data));
    var requestOptions = {
      method: "POST",
      headers: {
        "Content-type": "application/json",
      },
      body: JSON.stringify(data),
    };
    fetch("http://localhost:8088/hcr/customer/checkout", requestOptions).then(function (
      response
    ) {
      if (response.status == 200) {
        return response.json(); // Parse the response as JSON
      } else {
        throw new Error("Request failed with status: " + response.status);
      }
    });
    alert("Successful!");
    window.location.href = '/hcr/cart';
  }
}

function validateEmail(email) {
  var emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
  if (email === "") {
    return (document.getElementById("errorMessageEmail").textContent =
      "Email cannot be blank");
  }
  if (!emailRegex.test(email)) {
    return (document.getElementById("errorMessageEmail").textContent =
      "Invalid email (vv@vv.vv)");
  } else {
    document.getElementById("errorMessageEmail").textContent = "";

    const data = {
      email: email,
    };
    var requestOptions = {
      method: "POST",
      headers: {
        "Content-type": "application/json",
      },
      body: JSON.stringify(data),
    };
    // fetch("http://localhost:8088/hcr/person/email", requestOptions).then(
    //   function (response) {
    //     if (response.status == 200) {
    //       document.getElementById("errorMessageEmail").textContent =
    //         "Email has been used!";
    //       return response.json();
    //     } else {
    //       document.getElementById("errorMessageEmail").textContent = "";
    //     }
    //   }
    // );
  }
}

function validateName(firstName, lastName) {
  if (firstName === "" && lastName != "") {
    document.getElementById("errorMessageFirstname").textContent =
      "First name cannot be blank";
    document.getElementById("errorMessageLastname").textContent = "";
  }
  if (firstName != "" && lastName === "") {
    document.getElementById("errorMessageFirstname").textContent = "";
    document.getElementById("errorMessageLastname").textContent =
      "Last name cannot be blank";
  }
  if (firstName === "" && lastName === "") {
    document.getElementById("errorMessageFirstname").textContent =
      "First name cannot be blank";
    document.getElementById("errorMessageLastname").textContent =
      "Last name cannot be blank";
  }
  if (firstName != "" && lastName != "") {
    document.getElementById("errorMessageFirstname").textContent = "";
    document.getElementById("errorMessageLastname").textContent = "";
  }
}

function validateAddress(address) {
  if (address === "") {
    return (document.getElementById("errorMessageAddress").textContent =
      "Address cannot be blank");
  }
  if (address != "") {
    return (document.getElementById("errorMessageAddress").textContent = "");
  }
}

function validatePhone(phone) {
  var phoneRegex = /^[0-9]{10}$/;
  if (phone === "") {
    return (document.getElementById("errorMessagePhone").textContent =
      "Phone cannot be blank");
  }
  if (!phoneRegex.test(phone)) {
    return (document.getElementById("errorMessagePhone").textContent =
      "Invalid phone (10 numbers)");
  } else {
    document.getElementById("errorMessagePhone").textContent = "";
  }
}

function validatePassword(password) {
  if (password === "") {
    return (document.getElementById("errorMessagePassword").textContent =
      "Password cannot be blank");
  }
  if (password != "") {
    return (document.getElementById("errorMessagePassword").textContent = "");
  }
}

function validateUsername(username) {
  if (username === "") {
    return (document.getElementById("errorMessageUsername").textContent =
      "Username cannot be blank");
  }
  if (username != "") {
    document.getElementById("errorMessageUsername").textContent = "";
    const data = {
      userName: username,
    };
    var requestOptions = {
      method: "POST",
      headers: {
        "Content-type": "application/json",
      },
      body: JSON.stringify(data),
    };
    fetch("http://localhost:8088/hcr/person/username", requestOptions).then(
      function (response) {
        if (response.status == 200) {
          document.getElementById("errorMessageUsername").textContent =
            "Username has been used!";
          return response.json();
        } else {
          document.getElementById("errorMessageUsername").textContent = "";
        }
      }
    );
  }
}

function registerToDB() {
  const data = {
    firstName: firstName,
    lastName: lastName,
    address: address,
    email: email,
    phoneNumber: phone,
    password: password,
    gender: 1,
    userName: username,
  };
  var requestOptions = {
    method: "POST",
    headers: {
      "Content-type": "application/json",
    },
    body: JSON.stringify(data),
  };
  fetch("http://localhost:8088/hcr/register", requestOptions).then(function (
    response
  ) {
    if (response.status == 200) {
      return response.json(); // Parse the response as JSON
    } else {
      throw new Error("Request failed with status: " + response.status);
    }
  });
}
