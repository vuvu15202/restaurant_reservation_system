start();

function start() {
    getWaitlists(renderWaitlists);
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
    label.textContent = "Add Waitlist";

    //new event
    document.querySelector("#Add").onclick = function () {
        const formData = new FormData(document.getElementById("formData"));
        // formData.delete("tableID"); // add thi phai co dong nay
        const data = Object.fromEntries(formData);
        console.log(data);

        // console.log(JSON.stringify(data));
        addWaitlist(data, renderWaitlist(data));
    };
});
////////


function getWaitlists(callback) {
    var customerAPI = "http://localhost:8088/hcr/employee/customerwaitlists";
    fetch(customerAPI)
        .then(function (response) {
            return response.json();
        })
        .then(callback);

}
function renderWaitlists(tables) {
    console.log(tables);
    var table = document.querySelector("#waitlists");
    var htmls = tables.map(function (table, index) {
        console.log(table);

        return `
          <div class="container"
               style="background-color: #AEFAFF; border-radius: 20px; border: 1px solid #0695a0; margin-bottom: 10px;">
            <div class="row ">
              <h3 class="col-md-2 d-flex align-items-center justify-content-center">${table.bookingHour.substring(11,16)}</h3>
              <ul class="col-md-4">
                <li>Name: ${table.person.firstName} ${table.person.lastName}</li>
                <li>Phone: ${table.person.phoneNumber}</li>
                <li>Date : ${table.bookingHour.substring(0,10)}</li>
              </ul>
              <ul class=" col-md-3">
                <li>People: ${table.table.chairNumber}</li>
                <li>Table: ${table.table.tableID}</li>
              </ul>
              <ul class=" col-md-3">
                <li>
                  <div class="btn btn-danger">Cancel</div>
                </li>
                <li>
                  <div class="btn btn-dark">Detail</div>
                </li>
              </ul>
            </div>
          </div>
    `;
    });
    table.innerHTML += htmls.join("");
}

function addWaitlist(data, callback) {
    var customerAPI = "http://localhost:8088/hcr/employee/addwaitlist";
    var options = {
        method: "POST",
        headers: {
            'Content-type': 'application/x-www-form-urlencoded',
            // 'Accept': 'application/json'
        },
        body: data
    };
    console.log(JSON.stringify(data));
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
function renderWaitlist(table) {

    if (table != null) {
        var tbody = document.querySelector("#waitlists");
        tbody.innerHTML += `
          <div class="container"
               style="background-color: #AEFAFF; border-radius: 20px; border: 1px solid #0695a0; margin-bottom: 10px;">
            <div class="row ">
              <h3 class="col-md-2 d-flex align-items-center justify-content-center">${table.bookingHour.substring(11,16)}</h3>
              <ul class="col-md-4">
                <li>Name: ${table.firstName} ${table.lastName}</li>
                <li>Phone: ${table.phoneNumber}</li>
                <li>Date : ${table.bookingHour.substring(0,10)}</li>
              </ul>
              <ul class=" col-md-3">
                <li>People: </li>
                <li>Table: ${table.tableID}</li>
              </ul>
              <ul class=" col-md-3">
                <li>
                  <div class="btn btn-danger">Cancel</div>
                </li>
                <li>
                  <div class="btn btn-dark">Detail</div>
                </li>
              </ul>
            </div>
          </div>
          `;
    }
}