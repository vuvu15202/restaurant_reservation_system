
  
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

      function start(){
        getTables(renderTables);
      }


      //bam submit ko cho form gui request di
      const form = document.getElementById('formData');
      form.addEventListener('submit', function(event) {
          event.preventDefault();
      });
    

      // Add a click event listener to show the button
      document.getElementById("AddTrigger").addEventListener("click", function () {
        const add = document.getElementById("changeBtn"); add.innerHTML = `<button id="Add" type="button" class="btn btn-primary">Add</button>`;
        const label = document.getElementById("exampleModalLabel"); label.textContent = "Add Table";

        //new event
        document.querySelector('#Add').onclick = function(){
          const formData = new FormData(document.getElementById("formData"));
          formData.delete("tableID"); // add thi phai co dong nay
          const data = Object.fromEntries(formData);
          console.log(data);

          // console.log(JSON.stringify(data));
          addTable(formData, renderTable);
        }
      });


      // bat su kien click update de hien modal update
      function getTableToUpdate(id){ 

        //get table by id and render into modal
        getTable(id, renderForm);

        //show update button and label on modal
        const update = document.getElementById("changeBtn"); update.innerHTML = `<button id="Update" type="button" class="btn btn-primary">Update</button>`;
        const label = document.getElementById("exampleModalLabel"); label.textContent = "Update Table";

        //them su kien cho nut update
        document.querySelector('#Update').onclick = function(){
          const formData = new FormData(document.getElementById("formData")); 
          const data = Object.fromEntries(formData);
          console.log(data);

          updateTable(data, reRenderTable);
        }  
      }


      
      //bat su kien click 1 trong 3 nut empty, reserved, full
      function updateTableStatusOnClick(id, status){
        getTable(id,function(table){
          table.status=status;
          updateTableStatus(table, reRenderTable);
        });
      }


   // bat su kien click update de hien modal update
      // function getTableToUpdate(id){
      //   const update = document.getElementById("changeBtn"); update.innerHTML = `<button id="Update" type="button" class="btn btn-primary">Update</button>`;
      //   getTable(id, renderForm);
      // }
      
      
      //send request get all tables
      function getTables(callback){
        var customerAPI = 'http://localhost:8088/hcr/employee/table';
        fetch(customerAPI)
        .then(function(response){
          return response.json();
        })
        .then(callback);
      }
      
  
      //send request get table by id
      function getTable(id ,callback){
        var customerAPI = 'http://localhost:8088/hcr/employee/table/'+id;
        var options = {
          method: 'GET',
          headers:{
            'Content-type': 'application/json'
          }
        };
        fetch(customerAPI, options)
        .then(function(response){
          return response.json();
        })
        .then(callback);
      }
      
      
  
      // send request add table
      function addTable(data, callback){
        var customerAPI = 'http://localhost:8088/hcr/employee/table';
        var options = {
          method: 'POST',
          headers:{
            // 'Content-type': 'multipart/form-data',
            // 'Accept': 'application/json'
          },
          // body: JSON.stringify(data)
          body: data
        };
      
        fetch(customerAPI, options)
        .then(function(response){
          //  response.json();
          // console.log(response.json());
          console.log(response.status);
          if(response.status == 200){
            document.getElementById("addresult").setAttribute("style", "display: block;");
            setTimeout(function() {document.getElementById("addresult").style.display = "none";}, 2000);
            return response.json();
          }
          
        })
        .then(callback)
        .catch(function(error) {
            console.log(error);
          });
      }


  
      // send request update table
      function updateTable(data, callback){
        var customerAPI = 'http://localhost:8088/hcr/employee/table';
        var options = {
          method: 'PUT',
          headers:{
            'Content-type': 'application/json'
          },
          body: JSON.stringify(data)
          // body: data 
        };
      console.log(JSON.stringify(data));
        fetch(customerAPI, options)
        .then(function(response){
          
          console.log(response.status);
          if(response.status == 200){
            document.getElementById("addresult").setAttribute("style", "display: block;");
            setTimeout(function() {document.getElementById("addresult").style.display = "none";}, 2000);
            return response.json();
          }
        })
        .then(callback).catch(function(error) {
            console.log(error);
          });
      }


      // send request update table
      function updateTableStatus(table, callback){
        var customerAPI = 'http://localhost:8088/hcr/employee/table';
        var options = {
          method: 'PUT',
          headers:{
            'Content-type': 'application/json'
          },
          body: JSON.stringify(table)
        };
      
        fetch(customerAPI, options)
        .then(function(response){
          console.log(response.status);
          return response.json(); 
        })
        .then(callback).catch(function(error) {
            console.log(error);
          });
      }
      
      
      
      
      //call api to delete a table by id
      function deleteTable(id){
        var customerAPI = 'http://localhost:8088/hcr/employee/table/table';
        var options = {
          method: 'DELETE',
          headers:{
            'Content-type': 'application/json'
          }
        };
        fetch(customerAPI + '/'+id, options)
        .then(function(response){
          response.json();
        })
        .then(function(){
          var removeItem = document.querySelector('.table-item-' +id);
          if(removeItem){
            removeItem.remove();
          }
          
        });
      }
      
      
      function renderTables(tables){
        var table = document.querySelector('#tbody');
        var htmls = tables.map(function(table){
          console.log(table);
          // let images = "";
          // if(table.image){
          //   (table.image).split(';').forEach(element => {
          //     images += `<img src="/img/${element}" alt="Image">`;
          //   });
          // }
          
          var privacy;
          var status;

          if(table.status == 1) status=`<div style="color:green;">Empty</div>`;
          else if(table.status == 2) status=`<div style="color:orange;">Reserved</div>`;
          else if(table.status == 3) status=`<div style="color:red;">Full</div>`;

          if(table.privacy==0) privacy=`<div style="color:green;">Public</div>`;
          else privacy=`<div style="color:red;">Private</div>`;

          return `
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
        });
        table.innerHTML +=htmls.join('');
        
      }
      
  
      // 
      function renderTable(table){
        if(table != null){
          var tbody = document.querySelector('#tbody');
          // let images = "";
          // if(table.image){
          //   (table.image).split(';').forEach(element => {
          //     images += `<img src="/img/${element}" alt="Image">`;
          //   });
          // }
          var privacy;
          var status;

          if(table.status == 1) status=`<div style="color:green;">Empty</div>`;
          else if(table.status == 2) status=`<div style="color:orange;">Reserved</div>`;
          else if(table.status == 3) status=`<div style="color:red;">Full</div>`;

          if(table.privacy==0) privacy=`<div style="color:green;">Public</div>`;
          else privacy=`<div style="color:red;">Private</div>`;

          tbody.innerHTML +=`
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


      function reRenderTable(table){
        if(table !== null){
          var privacy;
          var status;
          if(table.status == 1) status=`<div style="color:green;">Empty</div>`;
          else if(table.status == 2) status=`<div style="color:orange;">Reserved</div>`;
          else if(table.status == 3) status=`<div style="color:red;">Full</div>`;
          if(table.privacy==0) privacy=`<div style="color:green;">Public</div>`;
          else privacy=`<div style="color:red;">Private</div>`;

          var updateItem = document.querySelector('.table-item-' +table.tableID);
          if(updateItem){
            updateItem.innerHTML= `
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
      function renderForm(table){
        document.querySelector('input[name="tableID"]').value = table.tableID;
        document.querySelector('input[name="chairNumber"]').value = table.chairNumber;
        document.querySelector('input[name="floorNo"]').value = table.floorNo;
        document.querySelector('input[name="privacy"]').value = table.privacy;

        if(table.status === 1) 	document.querySelector('input[id="Empty"]').checked = true;
        else if(table.status === 2) 	document.querySelector('input[id="Reserved"]').checked = true;
        else document.querySelector('input[id="Full"]').checked = true;
      }
      
      
      
    