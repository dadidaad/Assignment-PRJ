<%-- Document : index Created on : Oct 17, 2021, 8:20:57 PM Author : Admin --%>

<%@page import="model.Account" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">

        <title>Landing page</title>
        <meta content="" name="description">
        <meta content="" name="keywords">

        <!-- Favicons -->
        <link href="./assets/img/favicon.png" rel="icon">
        <link href="./assets/img/apple-touch-icon.png" rel="apple-touch-icon">

        <!-- Google Fonts -->
        <link
            href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
            rel="stylesheet">

        <!-- Vendor CSS Files -->
        <link href="./assets/vendor/aos/aos.css" rel="stylesheet">
        <link href="./assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="./assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
        <link href="./assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
        <link href="./assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
        <link href="./assets/vendor/remixicon/remixicon.css" rel="stylesheet">
        <link href="./assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

        <!-- Template Main CSS File -->
        <link rel="stylesheet" type="text/css" href="./assets/css/style.css"/>

    </head>

    <body>

        <!-- ======= Header ======= -->
        <jsp:include page="header.jsp"></jsp:include>
        <!-- End Header -->

        <!-- ======= Hero Section ======= -->
        <section id="hero" class="d-flex align-items-center justify-content-center">
            <div class="container" data-aos="fade-up">

                <div class="row justify-content-center" data-aos="fade-up" data-aos-delay="150">
                    <div class="col-xl-6 col-lg-8">
                        <h1>Inox Thanh Võ</h1>
                        <h2>Chuyên phân phối các mặt hàng inox xe máy</h2>
                    </div>
                </div>

                <div class="row gy-4 mt-5 justify-content-center" data-aos="zoom-in" data-aos-delay="250">
                    <div class="col-xl-2 col-md-4">
                        <div class="icon-box">
                            <i class="ri-store-line"></i>
                            <h3><a href="#">Tiện lợi</a></h3>
                        </div>
                    </div>
                    <div class="col-xl-2 col-md-4">
                        <div class="icon-box">
                            <i class="ri-bar-chart-box-line"></i>
                            <h3><a href="#E">Chính xác</a></h3>
                        </div>
                    </div>
                    <div class="col-xl-2 col-md-4">
                        <div class="icon-box">
                            <i class="ri-calendar-todo-line"></i>
                            <h3><a href="#">Nhanh chóng</a></h3>
                        </div>
                    </div>
                    <div class="col-xl-2 col-md-4">
                        <div class="icon-box">
                            <i class="ri-paint-brush-line"></i>
                            <h3><a href="#">Đẹp mắt</a></h3>
                        </div>
                    </div>
                    <div class="col-xl-2 col-md-4">
                        <div class="icon-box">
                            <i class="ri-database-2-line"></i>
                            <h3><a href="#">Giá cạnh tranh</a></h3>
                        </div>
                    </div>
                </div>

            </div>
        </section><!-- End Hero -->

        <main id="main">

            <!-- ======= About Section ======= -->
            <section id="about" class="about">
                <div class="container" data-aos="fade-up">

                    <div class="row">
                        <div class="col-lg-6 order-1 order-lg-2" data-aos="fade-left" data-aos-delay="100">
                            <img src="assets/img/store/background.JPG" class="img-fluid" alt="">
                        </div>
                        <div class="col-lg-6 pt-4 pt-lg-0 order-2 order-lg-1 content" data-aos="fade-right"
                             data-aos-delay="100">
                            <h3>Inox Thanh Võ </h3>
                            <p class="fst-italic">
                                Với hơn 20 năm kinh nghiệm trong việc sản xuất và phân phối mặt hàng Inox xe
                                máy,
                                chúng tôi cam kết
                            </p>
                            <ul>
                                <li><i class="ri-check-double-line"></i> Các mặt hàng liên tục cập nhật phù
                                    hợp
                                    với
                                    các dòng xe</li>
                                <li><i class="ri-check-double-line"></i> Giá cả luôn luôn cạnh tranh với
                                    những
                                    nhà
                                    phân phối khác</li>
                                <li><i class="ri-check-double-line"></i> Thời gian giao hàng nhanh chóng,
                                    đúng
                                    với
                                    thời gian hẹn</li>
                                <li><i class="ri-check-double-line"></i> Chế độ hậu mãi tốt</li>
                            </ul>
                        </div>
                    </div>

                </div>
            </section><!-- End About Section -->

            <!-- ======= Portfolio Section ======= -->
            <section id="portfolio" class="portfolio">
                <div class="container" data-aos="fade-up">

                    <div class="section-title">
                        <h2>Một vài sản phẩm của chúng tôi</h2>
                    </div>
                    <div class="row portfolio-container" data-aos="fade-up" data-aos-delay="200">

                        <div class="col-lg-4 col-md-6 portfolio-item filter-app">
                            <div class="portfolio-wrap">
                                <div class="portfolio-info">
                                    <h4>App 1</h4>
                                    <p>App</p>
                                    <div class="portfolio-links">
                                        <a href="assets/img/store/IMG_0629.JPG"
                                           data-gallery="portfolioGallery" class="portfolio-lightbox"
                                           title="App 1"><i class="bx bx-plus"></i></a>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="col-lg-4 col-md-6 portfolio-item filter-web">
                            <div class="portfolio-wrap">
                                <img src="assets/img/store/IMG_0632.JPG" class="img-fluid" alt="">
                                <div class="portfolio-info">
                                    <h4>Web 3</h4>
                                    <p>Web</p>
                                    <div class="portfolio-links">
                                        <a href="assets/img/store/IMG_0633.JPG"
                                           data-gallery="portfolioGallery" class="portfolio-lightbox"
                                           title="Web 3"><i class="bx bx-plus"></i></a>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="col-lg-4 col-md-6 portfolio-item filter-app">
                            <div class="portfolio-wrap">
                                <img src="assets/img/store/IMG_0634.JPG" class="img-fluid" alt="">
                                <div class="portfolio-info">
                                    <h4>App 2</h4>
                                    <p>App</p>
                                    <div class="portfolio-links">
                                        <a href="assets/img/store/IMG_E0628.JPG"
                                           data-gallery="portfolioGallery" class="portfolio-lightbox"
                                           title="App 2"><i class="bx bx-plus"></i></a>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="col-lg-4 col-md-6 portfolio-item filter-card">
                            <div class="portfolio-wrap">
                                <img src="assets/img/store/vongAbkochu72.JPG" class="img-fluid" alt="">
                                <div class="portfolio-info">
                                    <h4>Card 2</h4>
                                    <p>Card</p>
                                    <div class="portfolio-links">
                                        <a href="assets/img/store/vongAbkochu86.JPG"
                                           data-gallery="portfolioGallery" class="portfolio-lightbox"
                                           title="Card 2"><i class="bx bx-plus"></i></a>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="col-lg-4 col-md-6 portfolio-item filter-web">
                            <div class="portfolio-wrap">
                                <img src="assets/img/store/vongABloai72.JPG" class="img-fluid" alt="">
                                <div class="portfolio-info">
                                    <h4>Web 2</h4>
                                    <p>Web</p>
                                    <div class="portfolio-links">
                                        <a href="assets/img/store/VongABloai86.JPG"
                                           data-gallery="portfolioGallery" class="portfolio-lightbox"
                                           title="Web 2"><i class="bx bx-plus"></i></a>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="col-lg-4 col-md-6 portfolio-item filter-app">
                            <div class="portfolio-wrap">
                                <img src="assets/img/store/vongAlpha72.JPG" class="img-fluid" alt="">
                                <div class="portfolio-info">
                                    <h4>App 3</h4>
                                    <p>App</p>
                                    <div class="portfolio-links">
                                        <a href="assets/img/store/vongAlpha86.JPG"
                                           data-gallery="portfolioGallery" class="portfolio-lightbox"
                                           title="App 3"><i class="bx bx-plus"></i></a>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="col-lg-4 col-md-6 portfolio-item filter-card">
                            <div class="portfolio-wrap">
                                <img src="assets/img/store/vongElegpant86.JPG" class="img-fluid" alt="">
                                <div class="portfolio-info">
                                    <h4>Card 1</h4>
                                    <p>Card</p>
                                    <div class="portfolio-links">
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="col-lg-4 col-md-6 portfolio-item filter-card">
                            <div class="portfolio-wrap">
                                <div class="portfolio-info">
                                    <h4>Card 3</h4>
                                    <p>Card</p>
                                    <div class="portfolio-links">
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="col-lg-4 col-md-6 portfolio-item filter-web">
                            <div class="portfolio-wrap">
                                
                                <div class="portfolio-info">
                                    <h4>Web 3</h4>
                                    <p>Web</p>
                                    <div class="portfolio-links">
                                        
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>

                </div>
            </section><!-- End Portfolio Section -->


            <!-- ======= Contact Section ======= -->
            <section id="contact" class="contact">
                <div class="container" data-aos="fade-up">

                    <div class="section-title">
                        <h2>Liên lạc</h2>
                        <p>Liên lạc với chúng tôi</p>
                    </div>

                    <div>

                        <iframe
                            src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3728.5823481609104!2d106.65856851488057!3d20.848565199281396!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x314a7a6e3a647c1d%3A0x58a00524404ce961!2zQ-G6p3UgQW4gRMawxqFuZywgVMO0biDEkOG7qWMgVGjhuq9uZywgTGFtIFPGoW4sIEzDqiBDaMOibiwgSOG6o2kgUGjDsm5nLCBWaWV0bmFt!5e0!3m2!1sen!2s!4v1634475836475!5m2!1sen!2s"
                            width="100%" height="270" style="border:0;" allowfullscreen=""
                            loading="lazy"></iframe>
                    </div>

                    <div class="row mt-5">

                        <div class="col-lg-4">
                            <div class="info">
                                <div class="address">
                                    <i class="bi bi-geo-alt"></i>
                                    <h4>Địa chỉ:</h4>
                                    <p>XXX Tôn Đức Thắng - An Thái - An Dương - Hải Phòng</p>
                                </div>
                                <div class="email">
                                    <i class="bi bi-envelope"></i>
                                    <h4>Email:</h4>
                                    <p>vochithanhhp123@gmail.com</p>
                                </div>

                                <div class="phone">
                                    <i class="bi bi-phone"></i>
                                    <h4>Số Điện thoại:</h4>
                                    <p>+84 936 44 XXXX</p>
                                </div>

                            </div>

                        </div>

                        <div class="col-lg-8 mt-5 mt-lg-0">

                            <form action="" method="post" role="form"
                                  class="php-email-form">
                                <div class="row">
                                    <div class="col-md-6 form-group">
                                        <input type="text" name="name" class="form-control" id="name"
                                               placeholder="Tên của bạn" required>
                                    </div>
                                    <div class="col-md-6 form-group mt-3 mt-md-0">
                                        <input type="email" class="form-control" name="email" id="email"
                                               placeholder="Email của bạn" required>
                                    </div>
                                </div>
                                <div class="form-group mt-3">
                                    <input type="text" class="form-control" name="subject" id="subject"
                                           placeholder="Tiêu đề" required>
                                </div>
                                <div class="form-group mt-3">
                                    <textarea class="form-control" name="message" rows="5"
                                              placeholder="Tin nhắn" required></textarea>
                                </div>
                                <div class="my-3">
                                    <div class="loading">Loading</div>
                                    <div class="error-message"></div>
                                    <div class="sent-message">Tin Nhắn bạn đã được gửi</div>
                                </div>
                                <div class="text-center"><button type="submit">Gửi liên hệ</button></div>
                            </form>

                        </div>

                    </div>

                </div>
            </section><!-- End Contact Section -->

        </main><!-- End #main -->

        <!-- ======= Footer ======= -->
        <jsp:include page="footer.jsp"></jsp:include>
        <!-- End Footer -->

        <div id="preloader"></div>
        <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i
                class="bi bi-arrow-up-short"></i></a>

        <!-- Vendor JS Files -->
        <script src="./assets/vendor/aos/aos.js"></script>
        <script src="./assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="./assets/vendor/glightbox/js/glightbox.min.js"></script>
        <script src="./assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
        <script src="./assets/vendor/php-email-form/validate.js"></script>
        <script src="./assets/vendor/purecounter/purecounter.js"></script>
        <script src="./assets/vendor/swiper/swiper-bundle.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <!-- Template Main JS File -->
        <script src="./assets/js/main.js"></script>
        <script>
            // Get the modal
            var modalLogin = document.getElementById('id01');
            var modelRegister = document.getElementById('id02');
            // When the user clicks anywhere outside of the modal, close it
            window.onclick = function (event) {
                if (event.target == modalLogin) {
                    modalLogin.style.display = "none";
                }
            }
            window.onclick = function (event) {
                if (event.target == modelRegister) {
                    modalRegister.style.display = "none";
                }
            }

            var check = function () {
                if (document.getElementById('password').value ==
                        document.getElementById('confirm_password').value) {
                    document.getElementById('message').style.color = 'green';
                    document.getElementById('message').innerHTML = 'matching';
                } else {
                    document.getElementById('message').style.color = 'red';
                    document.getElementById('message').innerHTML = 'not matching';
                }
            }
        </script>
    </body>

</html>