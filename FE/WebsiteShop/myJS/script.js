const API_URL = 'http://localhost:8080'


getListNumberCartByUser();

function getListNumberCartByUser(){
    let userID = 2;

    axios.get(API_URL + `/cart/${userID}`).then((res)=> {
        document.getElementById("numberCart").innerHTML = res.data.length;
    })
}