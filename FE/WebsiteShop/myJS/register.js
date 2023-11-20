function registerForm() {

    tempContainer();

    function tempContainer() {
        document.getElementById("container").innerHTML = registerContainer();
    }

    function registerContainer() {
        return `
            <div id="container">
                <div id="colorlib-contact">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-2"></div>
                            <div class="col-md-8">
                            <div class="contact-wrap">
                                <h3>Register</h3>
                                <form action="#" class="contact-form">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="fname">User name</label>
                                                <input required type="text" id="username" class="form-control" placeholder="User name">
                                            </div>
                                        </div>
                                                 <div class="w-100"></div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="lname">Password</label>
                                                <input required type="password" id="password" class="form-control" placeholder="Password">
                                            </div>
                                        </div>
                                        <div class="w-100"></div>
                      <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="lname">Confirm Password</label>
                                                <input onchange="checkPassword()" required type="password" id="confirmPassword" class="form-control" placeholder="Your lastname">
                                            </div>
                                        </div>
                                        <div class="w-100"></div>
                        
                                        <div class="col-sm-12">
                                            <div class="form-group">
                                                <label for="email">Email</label>
                                                <input required type="email" id="email" class="form-control" placeholder="Your email address">
                                            </div>
                                        </div>
                                        <div class="w-100"></div>
        
                                        <div class="w-100"></div>
                                        <div class="col-sm-12">
                                            <div class="form-group">
                                                <input type="submit" value="Register" class="btn btn-primary" onclick="checkPassword()">
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div id="map" class="colorlib-map"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        `;
    }
}

function checkPassword() {
    let userName = document.getElementById("userName").value;

    // Gọi API để lấy list user
    axios.get('http://localhost:8080/users').then((respond) => {
        // Kiểm tra xem user có trong list user hay không
        const userExists = respond.data.find((user) => user.username === userName);
        console.log(userExists);
        if (userExists) {
            alert("Tên tài khoản đã tồn tại");
        } else {
            // Kiểm tra mật khẩu
            let password = document.getElementById("password").value;
            let confirmPassword = document.getElementById("confirmPassword").value;

            if (password === confirmPassword) {
                // Đăng ký tài khoản
                register();
            } else {
                alert("Mật khẩu không trùng khớp.");
            }
        }
    });
}

function register() {
    let username = document.getElementById("username").value;
    let password = document.getElementById("confirmPassword").value;
    let email = document.getElementById("email").value;
    console.log("xxxxxxxxxx")
    let user = {
        username: username,
        password: password,
        email: email
    }
    axios.post('http://localhost:8080/users/register', user).then((response) => {
        alert("đăng ký thành công")
        login();
    })
    event.preventDefault()
}
