let url = "http://localhost:8080/api/products";
axios.get(url).then((data) => {
    let product = data.data;
    console.log(product);
    let content = ""
    for (let i = 0; i < product.length; i++) {
        console.log(product[i].name);
        content += `<div class="col-md-3 col-lg-3 mb-4 text-center">
                <div class="product-entry border">
                    <a onclick="showProductDetail(${product[i].id}})"  class="prod-img">
                        <img  src="${product[i].imageList[0].image}" class="img-fluid" alt="Free html5 bootstrap 4 template">
                    </a>
                    <div class="desc">
                        <h2><a href="#">${product[i].name}</a></h2>
                        <span class="price">${product[i].price}</span>
                        <button class="btn btn-danger" onclick= viewDetail(${product[i].id})>View detail</button>
                        <button class="btn btn-danger" onclick=addToCart(${product[i].id})>Add to cart</button>
  
                    </div>
                </div>
            </div>`
    }
    document.getElementById("ShowProducts").innerHTML = content;
}).catch(() => {
    alert("not found")
})

function ShowMenOfProduct() {
    axios.get("http://localhost:8080/api/products/men").then((data) => {
        let product = data.data;
        console.log(product);
        let content = ""
        for (let i = 0; i < product.length; i++) {
            console.log(product[i].name);
            content += `<div class="col-md-3 col-lg-3 mb-4 text-center">
                <div class="product-entry border">
                    <a href="#" class="prod-img">
                        <img src="${product[i].imageList[0].image}" class="img-fluid" alt="Free html5 bootstrap 4 template">
                    </a>
                    <div class="desc">
                        <h2><a href="#">${product[i].name}</a></h2>
                        <span class="price">${product[i].price}</span>
                        <button class="btn btn-danger" onclick= viewDetail(${product[i].id})>View detail</button>
                        <button class="btn btn-danger" onclick=addToCart(${product[i].id})>Add to cart</button>
  
                    </div>
                </div>
            </div>`
        }
        document.getElementById("ShowProducts").innerHTML = content;
    }).catch(() => {
        alert("not found")
    })
}


function ShowWomenOfProduct() {
    axios.get("http://localhost:8080/api/products/women").then((data) => {
        let product = data.data;
        console.log(product);
        let content = ""
        for (let i = 0; i < product.length; i++) {
            console.log(product[i].name);
            content += `<div class="col-md-3 col-lg-3 mb-4 text-center">
                <div class="product-entry border">
                    <a href="#" class="prod-img">
                        <img src="${product[i].imageList[0].image}" class="img-fluid" alt="Free html5 bootstrap 4 template">
                    </a>
                    <div class="desc">
                        <h2><a href="#">${product[i].name}</a></h2>
                        <span class="price">${product[i].price}</span>
                        <button class="btn btn-danger" onclick= viewDetail(${product[i].id})>View detail</button>
                        <button class="btn btn-danger" onclick=addToCart(${product[i].id})>Add to cart</button>
  
                    </div>
                </div>
            </div>`
        }
        document.getElementById("ShowProducts").innerHTML = content;
    }).catch(() => {
        alert("not found")
    })
}

function searchProductByName(){
    let name = document.getElementById("mainSearch").value;

    let product= {
        name:name
    }
    axios.post("http://localhost:8080/api/products/productRepository",product).then((data) => {
        let product = data.data;
        console.log(product);
        let content = ""
        for (let i = 0; i < product.length; i++) {
            console.log(product[i].name);
            content += `<div class="col-md-3 col-lg-3 mb-4 text-center">
                <div class="product-entry border">
                    <a href="#" class="prod-img">
                        <img src="${product[i].imageList[0].image}" class="img-fluid" alt="Free html5 bootstrap 4 template">
                    </a>
                    <div class="desc">
                        <h2><a href="#">${product[i].name}</a></h2>
                        <span class="price">${product[i].price}</span>
                        <button onclick= viewDetail(${product[i].id})>View detail</button>
                        <button onclick=addToCart(${product[i].id})>Add to cart</button>
  
                    </div>
                </div>
            </div>`
        }
        document.getElementById("ShowProducts").innerHTML = content;
    }).catch(() => {
        alert("not found")
    })
}

function addToCart(productID) {
    let userID = localStorage.getItem("id");
    let cart = {
        user: {
            id: userID
        },
        product: {
            id: productID
        }
    }
    axios.put(API_URL + `/cart/add`, cart).then(() => {
        getListNumberCartByUser()
        alert("Tạo thành công")
    })
}

function viewDetail(productID) {

}