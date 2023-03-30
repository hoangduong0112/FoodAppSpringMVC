<%-- 
    Document   : detail.jsp
    Created on : Mar 28, 2023, 11:55:53 PM
    Author     : Duong Hoang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="row px-xl-5 justify-content-center">
    <div class="col-lg-5 pb-5">

        <img class="w-100 h-100" src="${store.image}" alt="${store.name}">

    </div>

    <div class="col-lg-5 pb-5">
        <h4 class="font-weight-semi-bold">${store.name}</h4>
        <h5 style="display:inline">Địa chỉ:</h5> <span class="mb-4"> ${store.address}
        </span>

        <div class="d-flex pt-2">
            <p class="text-dark font-weight-medium mb-0 mr-2">Share on:</p>
            <div class="d-inline-flex">
                <a class="text-dark px-2" href="">
                    <i class="fab fa-facebook-f"></i>
                </a>
                <a class="text-dark px-2" href="">
                    <i class="fab fa-twitter"></i>
                </a>
                <a class="text-dark px-2" href="">
                    <i class="fab fa-linkedin-in"></i>
                </a>
                <a class="text-dark px-2" href="">
                    <i class="fab fa-pinterest"></i>
                </a>
            </div>
        </div>
    </div>
</div>
<div class="row px-xl-5 justify-content-center">
    
        <div class="col-lg-3">ss
        </div>
        <div class="col-lg-6 mb-5">ss
        </div>
</div>