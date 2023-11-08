const API_URL = 'http://localhost:8080'


getListNumberCartByUser();

function getListNumberCartByUser(){
    let userID = localStorage.getItem('id');

    axios.get(API_URL + `/cart/${userID}`).then((res)=> {
        document.getElementById("numberCart").innerHTML = res.data.length;
    })
}

function getSelectedRadio(tag) {
    const radioButtons = document.getElementsByName(tag);

    for (let i = 0; i < radioButtons.length; i++) {
        if (radioButtons[i].checked) {
            return radioButtons[i].value;
        }
    }
}