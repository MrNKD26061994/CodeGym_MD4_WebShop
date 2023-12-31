function header() {
    // document.getElementById("adminRole").style.display = "none";
    let id = localStorage.getItem("id");
    console.log("ID " + id)
    axios.get(`http://localhost:8080/users/${id}`).then((res)=>{
        let listRole = res.data.advertisementSet;
        console.log(listRole)
        for (let i = 0; i < 3; i++) {
            if(listRole[i].roleName.includes("ROLE_ADMIN")) {
                console.log(listRole[i].roleName)
                document.getElementById("adminRole").style.display = "block";
            } else if(listRole[i].roleName.includes("ROLE_MODERATOR")) {
                console.log(listRole[i].roleName)
            } else {
                document.getElementById("adminRole").style.display = "none";
                console.log(listRole[i].roleName)
            }
        }
        // console.log("AAAAAAAA" + res.data.advertisementSet[0].roleName)
        // console.log("AAAAAAAA" + res.data.advertisementSet[1].roleName)
        // console.log("AAAAAAAA" + res.data.advertisementSet[2].roleName)
        // const role = res.data.advertisementSet[0].roleName;
        // if (role.includes("ROLE_ADMIN") ) {
        //     document.getElementById("adminRole").style.display = "block";
        // } else {
        //     document.getElementById("adminRole").style.display = "none";
        // }
        const username = res.data.username;
        document.getElementById("username").innerHTML = `<a id="username-content" onclick="userInfo()">${username}</a>`;
        document.getElementById("userImg").innerHTML = `
        <img style="width: 30px; border-radius: 50%" id="user-image" src="${res.data.image}" alt="User Image">`;
    })


    return `
    <nav class="colorlib-nav" role="navigation">
        <div class="top-menu">
            <div class="container">
                <div class="row">
                    <div class="col-sm-7 col-md-9">
                        <div id="colorlib-logo"><a href="index.html">Footwear</a></div>
                    </div>
                    <div class="col-sm-5 col-md-3">
                        <form action="#" class="search-wrap">
                            <div class="form-group">
                                <input id="mainSearch" type="search" class="form-control search" placeholder="Search" >
                                <button onclick="searchProductByName()" class="btn btn-primary submit-search text-center" type="submit"><i class="icon-search"></i></button>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-12 text-left menu-1">
                        <ul>
                            <li class="active"><a href="index.html">Home</a></li>
                            <li class="has-dropdown">
                                <a onclick="ShowMenOfProduct()">Men</a>
                                <ul class="dropdown">
                                    <li><a href="product-detail.html">Product Detail</a></li>
                                    <li><a href="cart.html">Shopping Cart</a></li>
                                    <li><a href="checkout.html">Checkout</a></li>
                                    <li><a href="order-complete.html">Order Complete</a></li>
                                    <li><a href="add-to-wishlist.html">Wishlist</a></li>
                                </ul>
                            </li>
                            <li><a onclick="ShowWomenOfProduct()">Women</a></li>
                            <li><a href="about.html">About</a></li>
                            <li><a href="contact.html">Contact</a></li>
                            <li><a onclick="filter()">Filter</a></li>
                            <li><a onclick="showFormReport()">Report</a></li>

                            <li class="cart"><a onclick="showCart()"><i class="icon-shopping-cart"></i> Cart [<span style="color: red" id="numberCart">0</span>]</a></li>
<!--                            <li class="cart" id="register" ><a onclick="registerForm()"><i class="icon-user-add"></i>Register</a></li>-->
<!--                             <li class="cart" id="login" ><a onclick="loginForm()"><i class="icon-log-in"></i>Login</a></li>-->

<!--                            -->
<!--                            <li class="cart" id="userImg"></li>-->
<!--                            <li class="cart" id="username"></li>-->
<!--                            <li class="cart" id="logout">-->
<!--                            <a onclick="logout()"><i class="icon-log-out"></i>Logout</a>-->
<!--                            </li>-->
                            
                            
                            <li id="adminRole" ><a onclick="adminForm()">Admin</a></li>
                            
                            <li class="cart" id="login" ><a onclick="loginForm()"><i class="icon-log-in"></i>Login</a></li>
                            <li class="cart" id="register" ><a onclick="registerForm()"><i class="icon-user-add"></i>Register</a></li>

                            <li class="cart" id="userImg"></li>
                            <li class="cart" id="username"></li>
                            <li class="cart" id="logout">
                            <a onclick="logout()"><i class="icon-log-out"></i>Logout</a>
                            </li>
                            
                            
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="sale">
            <div class="container">
                <div class="row">
                    <div class="col-sm-8 offset-sm-2 text-center">
                        <div class="row">
                            <div class="owl-carousel2">
                                <div class="item">
                                    <div class="col">
                                        <h3><a href="#">25% off (Almost) Everything! Use Code: Summer Sale</a></h3>
                                    </div>
                                </div>
                                <div class="item">
                                    <div class="col">
                                        <h3><a href="#">Our biggest sale yet 50% off all summer shoes</a></h3>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </nav>
    `
}