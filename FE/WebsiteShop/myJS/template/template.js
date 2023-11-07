tempHeader();

tempContainer();

tempFooter();

function tempHeader() {
    document.getElementById("header").innerHTML = header();
}

function tempContainer() {
    document.getElementById("container").innerHTML = container();
}

function tempFooter() {
    document.getElementById("footer").innerHTML = footer();
}

function container() {
    return `
    <div id="container">
        <div id="filter"></div>
        <div id="ShowProducts" class="row row-pb-md" style="text-align: center; width: 90%; align-items: center" ></div>

        <div class="colorlib-partner">
          <div class="container">
            <div class="row">
                <div class="col-sm-8 offset-sm-2 text-center colorlib-heading colorlib-heading-sm">
                    <h2>Trusted Partners</h2>
                </div>
            </div>
            <div class="row">
                <div class="col partner-col text-center">
                    <img src="images/brand-1.jpg" class="img-fluid" alt="Free html4 bootstrap 4 template">
                </div>
                <div class="col partner-col text-center">
                    <img src="images/brand-2.jpg" class="img-fluid" alt="Free html4 bootstrap 4 template">
                </div>
                <div class="col partner-col text-center">
                    <img src="images/brand-3.jpg" class="img-fluid" alt="Free html4 bootstrap 4 template">
                </div>
                <div class="col partner-col text-center">
                    <img src="images/brand-4.jpg" class="img-fluid" alt="Free html4 bootstrap 4 template">
                </div>
                <div class="col partner-col text-center">
                    <img src="images/brand-5.jpg" class="img-fluid" alt="Free html4 bootstrap 4 template">
                </div>
            </div>
        </div>
        </div>
    </div>
    `
}