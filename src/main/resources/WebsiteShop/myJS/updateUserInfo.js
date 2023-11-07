getUserName()
//Cấu hình firebase
const firebaseConfig = {
    apiKey: "AIzaSyBYwhcJE-WrIAAePLLEoFJ33ba1D2P38zc",
    authDomain: "kien-b06e6.firebaseapp.com",
    projectId: "kien-b06e6",
    storageBucket: "kien-b06e6.appspot.com",
    messagingSenderId: "234517503542",
    appId: "1:234517503542:web:b1841470b3a52471bac297",
    measurementId: "G-NYS2P0C4YT"
};
firebase.initializeApp(firebaseConfig);

const storage = firebase.storage();

function userInfo() {

    tempContainer();

    function tempContainer() {
        document.getElementById("container").innerHTML = userContainer();
    }

    function userContainer() {
        return `
<div class="container">
<div class="row">
\t\t<div class="col-12">
\t\t\t<!-- Page title -->
\t\t\t<div class="my-5">
\t\t\t\t<h3>My Profile</h3>
\t\t\t\t<hr>
\t\t\t</div>
\t\t\t<!-- Form START -->
\t\t\t<form class="file-upload">
\t\t\t\t<div class="row mb-5 gx-5">
\t\t\t\t\t<!-- Contact detail -->
                                            <div class="w-100"></div>
\t\t\t\t\t<div class="col-xxl-8 mb-5 mb-xxl-0">
\t\t\t\t\t\t<div class="bg-secondary-soft px-4 py-5 rounded">
\t\t\t\t\t\t\t<div class="row g-3">
\t\t\t\t\t\t\t\t<h4 class="mb-4 mt-0">Contact detail</h4>
\t\t\t\t\t\t\t\t<!-- First Name -->
                                            <div class="w-100"></div>
\t\t\t\t\t\t\t\t<div class="col-md-6">
\t\t\t\t\t\t\t\t\t<label class="form-label">Full Name *</label>
\t\t\t\t\t\t\t\t\t<input type="text" class="form-control" placeholder="" aria-label="First name" id="name">
\t\t\t\t\t\t\t\t</div>
                                            <div class="w-100"></div>
\t\t\t\t\t\t\t\t<!-- Phone number -->
\t\t\t\t\t\t\t\t<div class="col-md-6">
\t\t\t\t\t\t\t\t\t<label class="form-label">Phone number *</label>
\t\t\t\t\t\t\t\t\t<input type="text" class="form-control" placeholder="" aria-label="Phone number" id="phone">
\t\t\t\t\t\t\t\t</div>
                                            <div class="w-100"></div>
                                            \t\t\t\t\t\t\t\t<div class="col-md-6">
\t\t\t\t\t\t\t\t\t<label class="form-label">Birthday</label>
\t\t\t\t\t\t\t\t\t<input type="date" class="form-control" placeholder="" aria-label="Phone number" id="birthday">
\t\t\t\t\t\t\t\t</div>
                                            <div class="w-100"></div>
\t\t\t\t\t\t\t\t<!-- Email -->
\t\t\t\t\t\t\t\t<div class="col-md-6">
\t\t\t\t\t\t\t\t\t<label for="inputEmail4" class="form-label">Email *</label>
\t\t\t\t\t\t\t\t\t<input type="email" class="form-control" id="email" value="example@homerealty.com">
\t\t\t\t\t\t\t\t</div>
<div class="w-100"></div>
 <div class="form-group col-md-4">
      <label for="inputState">State</label>
      <select id="inputState" class="form-control">
        <option selected>Gender</option>
        <option >Male</option>
              <option>Female</option>
      </select>
    </div>
    <div class="w-100"></div>
    \t\t\t\t\t\t\t\t<div class="col-md-6">
\t\t\t\t\t\t\t\t\t<label class="form-label">Address</label>
\t\t\t\t\t\t\t\t\t<input type="text" class="form-control" placeholder="" aria-label="Phone number" id="address">
\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t</div> <!-- Row END -->
\t\t\t\t\t\t</div>
\t\t\t\t\t</div>
\t\t\t\t\t<!-- Upload profile -->
\t\t\t\t\t<div class="col-xxl-4">
\t\t\t\t\t\t\t\t\t\t</i>
\t\t\t\t\t\t<div class="bg-secondary-soft px-4 py-5 rounded">
\t\t\t\t\t\t\t<div class="row g-3">
\t\t\t\t\t\t\t\t<h4 class="mb-4 mt-0">Upload your profile photo</h4>
\t\t\t\t\t\t\t\t<div class="text-center">
\t\t\t\t\t\t\t\t\t<!-- Image upload -->
\t\t\t\t\t\t\t\t\t<div class="square position-relative display-2 mb-3">
\t\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t\t\t<!-- Button -->
\t\t\t\t\t\t\t\t\t<input type="file" id="customFile" name="file" hidden="">
\t\t\t\t\t\t\t\t\t<label class="btn btn-success-soft btn-block" for="customFile">Upload</label>
\t\t\t\t\t\t\t\t\t<button type="button" class="btn btn-danger-soft">Remove</button>
\t\t\t\t\t\t\t\t\t<!-- Content -->
\t\t\t\t\t\t\t\t\t<p class="text-muted mt-3 mb-0"><span class="me-1">Note:</span>Minimum size 300px x 300px</p>
\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t</div>
\t\t\t\t\t</div>
\t\t\t\t</div> <!-- Row END -->

\t\t\t\t<!-- Social media detail -->
\t\t\t\t<div class="row mb-5 gx-5">
\t\t\t\t\t<div class="col-xxl-6 mb-5 mb-xxl-0">
\t\t\t\t\t\t<div class="bg-secondary-soft px-4 py-5 rounded">
\t\t\t\t\t\t\t<div class="row g-3">
\t\t\t\t\t\t</div>
\t\t\t\t\t</div>
<!--\t\t\t\t\t&lt;!&ndash; change password &ndash;&gt;-->
<!--\t\t\t\t\t<div class="col-xxl-6">-->
<!--\t\t\t\t\t\t<div class="bg-secondary-soft px-4 py-5 rounded">-->
<!--\t\t\t\t\t\t\t<div class="row g-3">-->
<!--\t\t\t\t\t\t\t\t<h4 class="my-4">Change Password</h4>-->
<!--\t\t\t\t\t\t\t\t&lt;!&ndash; Old password &ndash;&gt;-->
<!--\t\t\t\t\t\t\t\t<div class="col-md-6">-->
<!--\t\t\t\t\t\t\t\t\t<label for="exampleInputPassword1" class="form-label">Old password *</label>-->
<!--\t\t\t\t\t\t\t\t\t<input type="password" class="form-control" id="exampleInputPassword1">-->
<!--\t\t\t\t\t\t\t\t</div>-->
<!--\t\t\t\t\t\t\t\t&lt;!&ndash; New password &ndash;&gt;-->
<!--\t\t\t\t\t\t\t\t<div class="col-md-6">-->
<!--\t\t\t\t\t\t\t\t\t<label for="exampleInputPassword2" class="form-label">New password *</label>-->
<!--\t\t\t\t\t\t\t\t\t<input type="password" class="form-control" id="exampleInputPassword2">-->
<!--\t\t\t\t\t\t\t\t</div>-->
<!--\t\t\t\t\t\t\t\t&lt;!&ndash; Confirm password &ndash;&gt;-->
<!--\t\t\t\t\t\t\t\t<div class="col-md-12">-->
<!--\t\t\t\t\t\t\t\t\t<label for="exampleInputPassword3" class="form-label">Confirm Password *</label>-->
<!--\t\t\t\t\t\t\t\t\t<input type="password" class="form-control" id="exampleInputPassword3">-->
<!--\t\t\t\t\t\t\t\t</div>-->
\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t</div>
\t\t\t\t\t</div>
\t\t\t\t</div> <!-- Row END -->
\t\t\t\t<!-- button -->
\t\t\t\t<div class="gap-3 d-md-flex justify-content-md-end text-center">
\t\t\t\t\t<button type="button" class="btn btn-danger btn-lg" style="text-align: center">Delete profile</button>
\t\t\t\t\t<button type="button" class="btn btn-primary btn-lg" onclick="editInfo()">Update profile</button>
\t\t\t\t</div>
\t\t\t</form> <!-- Form END -->
\t\t</div>
\t</div>
\t</div>
        `;
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
            document.getElementById("username-content").innerHTML = username;
        }
    });
}
function editInfo() {
    const fileInput = document.getElementById("customFile");
    // Lấy file hình ảnh từ input
    const file = fileInput.files[0];

    // Tạo tham chiếu đến nơi bạn muốn lưu trữ ảnh trong Storage
    const storageRef = storage.ref("kien/" + file.name);
let gender;
    // Tải file lên Firebase Storage
    storageRef.put(file).then((snapshot) => {
        console.log("Uploaded a file!");

        // Lấy URL của ảnh sau khi đã tải lên
        storageRef.getDownloadURL().then((url) => {
            console.log(url);
            let data = {
                id: localStorage.getItem("id"),
                name: document.getElementById('name').value,
                address:document.getElementById('address').value,
                phone: document.getElementById('phone').value,
                email: document.getElementById('email').value,
                // birthday : document.getElementById('birthday').value,
                // gender : gender,
                image: url
            }
            console.log(data)
            axios.put('http://localhost:8080/users/edit', data).then(() => {
                alert("sửa thành công")
            });
        });
    });
}
