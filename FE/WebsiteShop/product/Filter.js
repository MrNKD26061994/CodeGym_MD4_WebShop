function filterForm(){
let content=`<table style="width: 100%; border: 1px solid; margin: 20px">
    <tr>
        <td>Filter</td>
        <td colspan="4"></td>
    </tr>
    <tr>
        <td colspan="2" style="width: 30%">Price gape</td>
        <td style="width: 30%">Category</td>
        <td style="width: 30%">Gender</td>
        <td rowspan="2"><button onclick="search()">search</button> </td>
     </tr>
      <tr>
        <td colspan="2"><input id="lowPrice" type="text" placeholder="nhập giá min"> <label> >>> </label> <input id="highPrice" type="text" placeholder="nhập giá max"></td>
        <td><select  id="category"></select></td> 
        <td><input type="text" id="name" placeholder="nhập tên sản phẩm"></td>
        
       
     </tr>
</table>`
    document.getElementById("filter").innerHTML=content;
}

function filter(){
    filterForm();
}

function loadCategory(){

}

function search(){
    let num1 = document.getElementById("lowPrice").value;
    let num2 = document.getElementById("highPrice").value;
    let id = document.getElementById("category").value;
    let name = document.getElementById("name").value;
    let searchOBJ ={
        num1:num1,
        num2:num2,
        id:id,
        name:name
    }
    axios.post("http://localhost:8080/api/products/filter",searchOBJ).then((data) => {
        let product = data.data;
        console.log(product);
        let content = ""
        for (let i = 0; i < product.length; i++) {
            console.log(product[i].name);
            content += `<div class="col-md-3 col-lg-3 mb-4 text-center">
                <div class="product-entry border">
                    <a href="#" class="prod-img">
                        <img src="https://www.dungplus.com/wp-content/uploads/2019/12/girl-xinh-2.jpg" class="img-fluid" alt="Free html5 bootstrap 4 template">
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