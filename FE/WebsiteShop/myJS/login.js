function loginform() {

    tempContainer();

    function tempContainer() {
        document.getElementById("container").innerHTML = loginContainer();
    }

    function loginContainer() {
        return `
            <div id="container">
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
                                                <label for="fname">First Name</label>
                                                <input type="text" id="fname" class="form-control" placeholder="Your firstname">
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="lname">Last Name</label>
                                                <input type="text" id="lname" class="form-control" placeholder="Your lastname">
                                            </div>
                                        </div>
                                        <div class="w-100"></div>
                                        <div class="col-sm-12">
                                            <div class="form-group">
                                                <label for="email">Email</label>
                                                <input type="text" id="email" class="form-control" placeholder="Your email address">
                                            </div>
                                        </div>
                                        <div class="w-100"></div>
                                        <div class="col-sm-12">
                                            <div class="form-group">
                                                <label for="subject">Subject</label>
                                                <input type="text" id="subject" class="form-control" placeholder="Your subject of this message">
                                            </div>
                                        </div>
                                        <div class="w-100"></div>
                                        <div class="col-sm-12">
                                            <div class="form-group">
                                                <label for="message">Message</label>
                                                <textarea name="message" id="message" cols="30" rows="10" class="form-control" placeholder="Say something about us"></textarea>
                                            </div>
                                        </div>
                                        <div class="w-100"></div>
                                        <div class="col-sm-12">
                                            <div class="form-group">
                                                <input type="submit" value="Send Message" class="btn btn-primary">
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