
function showFormReport(){
    let content = `
    <H2>Revenue report </H2>
    <table>
    <tr><td><a class="active"  onclick="showReportPerYear()">Show yearly report </a></td></tr>
    <tr><td><a class="active"  onclick="showReportPerMonth()">Show monthy report </a></td></tr>
    </table>
    `
    document.getElementById("filter").innerHTML=content;
}

function showReportPerYear(){
    let content = `
    <H2>Revenue report </H2>
    <table>
    <tr>
    <td><lable>Type the year: </lable></td>
    <td><input id="year" type="text"></td>
    <td><button class="btn btn-danger"  onclick="showReportByYear()">Show report</button></td>
    </tr>
   
    </table>
    `
    document.getElementById("filter").innerHTML=content;
}

function showReportPerMonth(){
    let content = `
    <H2>Revenue report </H2>
    <table>
    <tr>
    <td><lable>Type the year: </lable></td>
    <td><input id="num_1" type="text"></td>
    <td><lable>Type the month: </lable></td>
    <td><input id="num_2" type="text"></td>
    <td><button class="btn btn-danger"  onclick="showReportByMonth()">Show report</button></td>
    </tr>
    </table>
    `
    document.getElementById("filter").innerHTML=content;
}

function showReportByYear() {
    let content=`<canvas class="container text-center" id="myChart" style="width:100%;max-width:1000px; margin: 30px"></canvas>`
    document.getElementById("ShowProducts").innerHTML=content;

    let year = document.getElementById("year").value;
    let maxPrice = 1000;
    let searchOBJ = {num1: year}
    axios.post("http://localhost:8080/api/reports", searchOBJ).then((data) => {
        let xValues = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12];
        let yValues = [];
        let OrderProduct = data.data;
        for (let i = 0; i < xValues.length; i++) {
            let totalPrice = 0;
            for (let j = 0; j < OrderProduct.length; j++) {
                let dateTimeString = OrderProduct[j].orders.time;
                let createDate = new Date(dateTimeString);
                let month = createDate.getMonth() + 1;
                if (month === xValues[i]) {
                    totalPrice = totalPrice + OrderProduct[j].price;
                }
            }
            yValues.push(totalPrice);
        }
        for (let i = 0; i < yValues.length; i++) {
            if(yValues[i]>maxPrice){
                maxPrice=yValues[i];
            }
        }
        console.log(yValues);
        new Chart("myChart", {
            type: "line",
            data: {
                labels: xValues,
                datasets: [{
                    fill: false,
                    lineTension: 0,
                    backgroundColor: "rgba(0,0,255,1.0)",
                    borderColor: "rgba(0,0,255,0.1)",
                    data: yValues
                }]
            },
            options: {
                legend: {display: false},
                scales: {
                    yAxes: [{ticks: {min: 0, max:maxPrice}}],
                }
            }
        });
    });
}

function showReportByMonth(){
    let content=`<canvas class="container text-center" id="myChart2" style="width:100%;max-width:1000px; margin: 30px"></canvas>`
    document.getElementById("ShowProducts").innerHTML=content;

    let num1 = document.getElementById("num_1").value;
    let num2 = document.getElementById("num_2").value;

    let maxPrice = 1000;
    let searchOBJ = {num1: num1,
                                num2:num2
                                }
 if(num1==""&&num2==""){
        alert("You must fill enough info!")
 }else if(num1==""&&num2!=""){
     alert("You have to choose the year!!!")
 } else if(num1!=""&& num2=="") {
     let content=`<canvas class="container text-center" id="myChart" style="width:100%;max-width:1000px; margin: 30px"></canvas>`
     document.getElementById("ShowProducts").innerHTML=content;

     let year = document.getElementById("num_1").value;
     let maxPrice = 1000;
     let searchOBJ = {num1: year}
     axios.post("http://localhost:8080/api/reports", searchOBJ).then((data) => {
         let xValues = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12];
         let yValues = [];
         let OrderProduct = data.data;
         for (let i = 0; i < xValues.length; i++) {
             let totalPrice = 0;
             for (let j = 0; j < OrderProduct.length; j++) {
                 let dateTimeString = OrderProduct[j].orders.time;
                 let createDate = new Date(dateTimeString);
                 let month = createDate.getMonth() + 1;
                 if (month === xValues[i]) {
                     totalPrice = totalPrice + OrderProduct[j].price;
                 }
             }
             yValues.push(totalPrice);
         }
         for (let i = 0; i < yValues.length; i++) {
             if(yValues[i]>maxPrice){
                 maxPrice=yValues[i];
             }
         }
         console.log(yValues);
         new Chart("myChart", {
             type: "line",
             data: {
                 labels: xValues,
                 datasets: [{
                     fill: false,
                     lineTension: 0,
                     backgroundColor: "rgba(0,0,255,1.0)",
                     borderColor: "rgba(0,0,255,0.1)",
                     data: yValues
                 }]
             },
             options: {
                 legend: {display: false},
                 scales: {
                     yAxes: [{ticks: {min: 0, max:maxPrice}}],
                 }
             }
         });
     });
 }else {

    axios.post("http://localhost:8080/api/reports/month", searchOBJ).then((data) => {
        let xValues = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31];
        let yValues = [];
        let OrderProduct = data.data;
        for (let i = 0; i < xValues.length; i++) {
            let totalPrice = 0;
            for (let j = 0; j < OrderProduct.length; j++) {
                let dateTimeString = OrderProduct[j].orders.time;
                let createDate = new Date(dateTimeString);
                let day = createDate.getDate();
                if (day === xValues[i]) {
                    totalPrice = totalPrice + OrderProduct[j].price;
                }
            }
            yValues.push(totalPrice);
        }
        for (let i = 0; i < yValues.length; i++) {
            if(yValues[i]>maxPrice){
                maxPrice=yValues[i];
            }
        }
        console.log(yValues);
        new Chart("myChart2", {
            type: "line",
            data: {
                labels: xValues,
                datasets: [{
                    fill: false,
                    lineTension: 0,
                    backgroundColor: "rgba(0,0,255,1.0)",
                    borderColor: "rgba(0,0,255,0.1)",
                    data: yValues
                }]
            },
            options: {
                legend: {display: false},
                scales: {
                    yAxes: [{ticks: {min: 0, max:maxPrice}}],
                }
            }
        });
    })};
}