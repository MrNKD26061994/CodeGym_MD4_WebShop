function showReportByYear() {
    let content = `<canvas id="myChart" style="width:100%;max-width:600px"></canvas>`
    document.getElementById("ShowProducts").innerHTML = content;
    let xValues = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12];
    let yValues = [];
    let year = 2023;
    let PriceArr = [];
    let maxPrice = 1000;
    let searchOBJ = {num1: year}
    axios.post("http://localhost:8080/api/reports", searchOBJ).then((data) => {
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
                // PriceArr.push(totalPrice);
            }
            yValues.push(totalPrice);
        }
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
                    yAxes: [{ticks: {min: 0, max:1000}}],
                }
            }
        });
    });


}

