function showOrder() {
    checkoutContainer();
    formInput();
    cartTotal();
    listPay();
}

function checkoutContainer() {
    document.getElementById("container").innerHTML = orderContainer();
}
function orderContainer() {
    return `
<div>
<div class="breadcrumbs">
    <div class="container">
        <div class="row">
            <div class="col">
                <p class="bread"><span><a href="index.html">Home</a></span> / <span>Checkout</span></p>
            </div>
        </div>
    </div>
</div>

<div class="colorlib-product">
    <div class="container">
        <div class="row row-pb-lg">
            <div class="col-sm-10 offset-md-1">
                <div class="process-wrap">
                    <div class="process text-center active">
                        <p><span>01</span></p>
                        <h3>Shopping Cart</h3>
                    </div>
                    <div class="process text-center active">
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
        
        <div class="row">
            <div id="formCheckout" class="col-lg-8">
                
            </div>

            <div class="col-lg-4">
                <div class="row">
                    <div id="cartTotal" class="col-md-12">
                        
                    </div>

                    <div class="w-100"></div>

                    <div id="listPay" class="col-md-12">
                        
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12 text-center">
                        <p><a onclick="pay()" class="btn btn-primary">Place an order</a></p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</div>
        `
}

function formInput() {
    let userID = localStorage.getItem("id");
    axios.get(API_URL + `/users/${userID}`).then((res)=> {
        let user = res.data;
        let str = `
<form method="post" class="colorlib-form">
    <h2>Billing Details</h2>
    <div class="row">
        <div class="col-md-12">
            <div class="form-group">
                <label for="fname">Name</label>
                <input value="${user.name}" type="text" id="fname" class="form-control" placeholder="Your name">
            </div>
        </div>

        <div class="col-md-12">
            <div class="form-group">
                <label for="fname">Delivery address</label>
                <input type="text" id="address" class="form-control" placeholder="Enter Your Address">
            </div>
        </div>

        <div class="col-md-12">
            <div class="form-group">
                <label for="Phone">Phone Number</label>
                <input value="${user.phone}" type="text" id="zippostalcode" class="form-control" placeholder="Enter Your Phone">
            </div>
        </div>

    </div>
</form>
        `
        document.getElementById("formCheckout").innerHTML = str;
    })
}

function cartTotal() {
    let userID = localStorage.getItem("id");
    axios.get(API_URL + `/cart/listCheck/${userID}`).then((res)=> {
        let carts = res.data;
        let subTotal = 0;
        let discount = 0;
        // let name = carts[0].name;
        let str = `
    <div class="cart-detail">
        <h2>Cart Total</h2>
        <ul>
            <li>
                <ul>`;
        for (let i = 0; i < carts.length; i++) {
            subTotal += carts[i].product.price * carts[i].count;
            discount += carts[i].product.discount * carts[i].product.price * carts[i].count / 100;
            str += `
                <li>
                <span class="listCount">${carts[i].count} x ${carts[i].product.name}</span> 
                <span class="listPrice">$${carts[i].product.price}</span></li>
            `
        }
        str += `
            </ul>
        </li>
        <li><span>Subtotal</span> <span>$${subTotal}</span></li>
        <li><span>Shipping</span> <span>$0.00</span></li>
        <li><span>Discount</span> <span>$${discount*(-1)}</span></li>
        <li><span>Order Total</span> <span>$${subTotal+discount*(-1)}</span></li>
    </u
</div>
        `
        document.getElementById("cartTotal").innerHTML = str;

    })
}

function listPay() {
    axios.get(API_URL + `/pays`).then((res)=> {
        let pays = res.data;
        let str = `
        <div class="cart-detail">
    <h2>Payment Method</h2>
    `
        for (let i = 0; i < pays.length; i++) {
            str += `
            <div class="form-group">
                <div class="col-md-12">
                    <div class="radio">
                        <label><input type="radio" name="optradio" value="${pays[i].id}"> ${pays[i].name}</label>
                    </div>
                </div>
            </div>      
            `
        }
        str += `</div>`
        document.getElementById("listPay").innerHTML = str;
    })
}

function pay(){
    let userID = localStorage.getItem("id");
    let address = document.getElementById("address").value;
    let payID = getSelectedRadio("optradio");
    let data = {
        address: address,
        pay: {
            id: payID
        },
        user: {
            id: userID
        }
    }
    Promise.all([
        axios.post(API_URL + `/orders`, data),
        axios.get(API_URL + `/cart/listCheck/${userID}`)
    ]).then((res) =>{
        let orderID = res[0].data.id;
        let carts = res[1].data;
        let customerPayDTO = {
            pay: {
                id: payID
            },
            address: address,
            user: {
                id: userID
            },
            cartList: carts
        }
        axios.post(API_URL + `/customer`, customerPayDTO).then(() => {
            alert("Tạo thành công")
        })
    })


}