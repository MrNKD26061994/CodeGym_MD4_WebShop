function showCart(){
    tempContainer();

    getStatusCheckAll()

    listCart();

    // getChecked()

    total();

}
function tempContainer() {
    document.getElementById("container").innerHTML = cartContainer();
}

function cartContainer() {
    return `
            <div>
<div class="breadcrumbs">
    <div class="container">
        <div class="row">
            <div class="col">
                <p class="bread"><span><a href="index.html">Home</a></span> / <span>Shopping Cart</span></p>
            </div>
        </div>
    </div>
</div>

<div class="colorlib-product">
    <div class="container">
        <div class="row row-pb-lg">
            <div class="col-md-10 offset-md-1">
                <div class="process-wrap">
                    <div class="process text-center active">
                        <p><span>01</span></p>
                        <h3>Shopping Cart</h3>
                    </div>
                    <div class="process text-center">
                        <p><span>02</span></p>
                        <h3>Checkout</h3>
                    </div>
                    <div class="process text-center">
                        <p><span>03</span></p>
                        <h3>Order Complete</h3>
                    </div>
                </div>
            </div>
        </div>
        
        <div class="row row-pb-lg">
            <div class="col-md-12">
                <div class="product-name d-flex align-items-center">
                    <div class="one-eight text-center">
                        <input onclick="toggleAll(this)" style="width: 20px" type="checkbox" id="checkAll" class="form-control text-center">
                    </div>
                    <div class="one-forth text-left px-4">
                        <span>Product Details</span>
                    </div>
                    <div class="one-eight text-center">
                        <span>Price</span>
                    </div>
                    <div class="one-eight text-center">
                        <span>Quantity</span>
                    </div>
                    <div class="one-eight text-center">
                        <span>Discount</span>
                    </div>
                    <div class="one-eight text-center">
                        <span>Total</span>
                    </div>
                    <div class="one-eight text-center px-4">
                        <span>Remove</span>
                    </div>
                </div>
                
                <div id="listCart"></div>
                
            </div>
        </div>
        
        <div class="row row-pb-lg">
            <div class="col-md-12">
                <div class="total-wrap">
                    <div class="row">
                        <div class="col-sm-8">
                            <form action="#">
                                <div class="row form-group">
                                    <div class="col-sm-9">
                                        <input type="text" name="quantity" class="form-control input-number" placeholder="Your Coupon Number...">
                                    </div>
                                    <div class="col-sm-3">
                                        <input type="submit" onclick="showOrder()" value="Checkout" class="btn btn-primary">
                                    </div>
                                </div>
                            </form>
                        </div>
                        
                        <div id="total" class="col-sm-4 text-center"></div>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>
            </div>
        `
}

function listCart(){
    let userID = 2;

    axios.get(API_URL + `/cart/${userID}`).then((res)=> {
        let str = ``;
        let listCart = res.data
        for (let i = 0; i < listCart.length; i++) {
            let str2 = "";
            if(listCart[i].checked){
                str2 = `<input checked id="check" value="${listCart[i].product.id}" name="user-product" style="width: 20px" type="checkbox" class="form-control text-center">`
            } else {
                str2 = `<input id="check" value="${listCart[i].product.id}" name="user-product" style="width: 20px" type="checkbox" class="form-control text-center">`
            }
            let str1 = `
                        <div class="product-cart d-flex">
                        <div class="one-eight text-center">
                        <div class="display-tc">`
            let str3 = `</div>
                    </div>
                    <div class="one-forth">
                        <div class="product-img" style="background-image: url(images/item-6.jpg);">
                        </div>
                        <div class="display-tc">
                            <h3>${listCart[i].product.name}</h3>
                        </div>
                    </div>
                    <div class="one-eight text-center">
                        <div class="display-tc">
                            <span class="price">$${listCart[i].product.price}</span>
                        </div>
                    </div>
                    <div class="one-eight text-center">
                        <div class="display-tc">
                            <input type="number" id="${listCart[i].product.id}" name="quantity" class="form-control input-number text-center" value="${listCart[i].count}" min="1" max="100">
                        </div>
                    </div>
                    <div class="one-eight text-center">
                        <div class="display-tc">
                            <span style="color: red" class="price">-${listCart[i].product.discount}%</span>
                        </div>
                    </div>
                    
                    <div class="one-eight text-center">
                        <div class="display-tc">
                            <span class="price">$${(listCart[i].count * listCart[i].product.price)*(100-listCart[i].product.discount)/100}</span>
                        </div>
                    </div>
                    <div class="one-eight text-center">
                        <div class="display-tc">
                            <a href="#" class="closed"></a>
                        </div>
                    </div>
            </div>`

            str += (str1 + str2 + str3);
        }
        document.getElementById("listCart").innerHTML = str;
        getChecked()
        changeQuantity()
        total()
    })
}

function changeQuantity() {
    let numberInputs = document.querySelectorAll("input[type='number']");

    numberInputs.forEach(function(input) {
        input.addEventListener("change", function() {
            let value = this.value; // Lấy giá trị của checkbox
            console.log("Giá trị của input vừa thay đổi là: " + value);
            console.log(input.id)
            let userID = 2;
            let productID = input.id;
            axios.put(API_URL + `/cart/${productID}/${userID}/${value}`).then(()=> {

            })
        });
    });

}

function getStatusCheckAll() {
    let userID = 2;
    axios.get(API_URL + `/cart/checkAll/${userID}`).then((res)=> {
        if(res.data) {
            document.getElementById("checkAll").checked = true;
        } else {
            document.getElementById("checkAll").checked = false;
        }
    })
}
function toggleAll(source) {
    let checkboxes = document.getElementsByName("user-product");
    // Lặp qua danh sách checkbox con và đặt trạng thái của chúng
    for(let i=0, n=checkboxes.length;i<n;i++) {
        checkboxes[i].checked = source.checked;
    }
    let userID = 2;
    let check = source.checked;
    axios.put(API_URL + `/cart/checkAll/${userID}/${check}`).then(()=> {

    })
}
function getChecked(){
    let checkboxes = document.querySelectorAll('input[type="checkbox"]');
    checkboxes.forEach(function(checkbox) {
        checkbox.addEventListener("change", function() {
            let isChecked = this.checked; // Lấy giá trị của checkbox
            console.log("Giá trị của checkbox vừa thay đổi là: " + isChecked);
            console.log(checkbox.value)

            let userID = 2;
            let productID = checkbox.value;
            axios.put(API_URL + `/cart/${userID}/${productID}`).then(()=> {
                getStatusCheckAll();
            })
        });
    });
}

function total() {
    let userID = 2;
    axios.get(API_URL + `/cart/listCheck/${userID}`).then((res)=> {
        let carts = res.data;
        let subTotal = 0;
        let discount = 0;
        for (let i = 0; i < carts.length; i++) {
            subTotal += carts[i].product.price * carts[i].count;
            discount += carts[i].product.discount * carts[i].product.price * carts[i].count / 100;
        }
        document.getElementById("total").innerHTML = `
    <div class="total">
        <div class="sub">
            <p><span>Subtotal:</span> <span>$${subTotal}</span></p>
            <p><span>Delivery:</span> <span>$0.00</span></p>
            <p><span>Discount:</span> <span>$${discount*(-1)}</span></p>
        </div>
        <div class="grand-total">
            <p><span><strong>Total:</strong></span> <span>$${subTotal+discount*(-1)}</span></p>
        </div>
    </div>
    `

    })
}


