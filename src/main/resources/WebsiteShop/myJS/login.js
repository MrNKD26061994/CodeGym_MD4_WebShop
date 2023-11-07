hide();

function loginForm() {

    tempContainer();

    function tempContainer() {
        document.getElementById("container").innerHTML = loginContainer();
    }
    function loginContainer() {
        return `
            <div id="loginContainer" xmlns="http://www.w3.org/1999/html">
                <div id="colorlib-contact">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-3"></div>
                            <div class="col-md-6">
                            <div class="contact-wrap">
                                <h3>Login</h3>
                                <form action="#" class="contact-form">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="fname">User Name</label>
                                                <input type="text" id="userName" class="form-control" placeholder="UserName">
                                            </div>
                                        </div>
                                            <div class="w-100"></div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="lname">Password</label>
                                                <input type="password" id="password" class="form-control" placeholder="Password">
                                            </div>
                                        </div>
                                        <div class="w-100"></div>
                                        <div class="col-sm-12">
                                            <div class="form-group">
                                                <button type="submit" value="LOGIN" class="btn btn-primary" onclick="login()">LOGIN
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

function login() {
    let userName = document.getElementById("userName").value;
    let passWord = document.getElementById("password").value;
    let user = {
        userName: userName,
        password: passWord
    }
    axios.post('http://localhost:8080/users/login', user).then((response) => {
        localStorage.setItem("token", response.data.token);
        localStorage.setItem("userName", response.data.username)
        localStorage.setItem("id", response.data.userId)
        const role = response.data.listRole;
        console.log(response.data.listRole)
        if (role[0] === "ROLE_ADMIN") {
            console.log("admin")
            location.reload();
        } else if (role[0] === "ROLE_USER") {
            console.log("user")
            location.reload();
        } else if (role[0] === "ROLE_MODERATOR"){
            console.log("moderator")
            location.reload();
        }
        else {
            alert("Sai tài khoản hoặc mật khẩu")
        }
        getUserName();
        location.reload();
    })
}

function hide() {
    let token = localStorage.getItem("token")
    if (token !== null) {
        document.getElementById("register").style.display = "none"
        document.getElementById("login").style.display = "none"
        document.getElementById("logout").style.display = "block"
        document.getElementById("username").style.display = "block"
        document.getElementById("userImg").style.display = "block"
    }
    if (token === null) {
        document.getElementById("register").style.display = "block"
        document.getElementById("login").style.display = "block"
        document.getElementById("logout").style.display = "none"
        document.getElementById("username").style.display = "none"
        document.getElementById("userImg").style.display = "none"
    }
}
function getUserName() {
    let id = localStorage.getItem("id");
    console.log(id)
    // Gửi yêu cầu HTTP GET đến API
    axios.get(`http://localhost:8080/users/${id}`).then((response) => {
        if (response.status === 200) {
            // Lấy tên user từ phản hồi
            const username = response.data.username;
            console.log(username);
            document.getElementById("username").innerHTML = `<a id="username-content" onclick="userInfo()">${username}</a>`;
            document.getElementById("userImg").innerHTML = `
<img style="width: 30px; border-radius: 50%" id="user-image" src="${response.data.image}" alt="User Image">`;
            // Hiển thị ảnh người dùng
        }
    });
}
function logout() {
    localStorage.clear();
    location.reload();
    window.location.href("index.html")
}
