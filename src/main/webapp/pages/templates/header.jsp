<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="<c:url value="/pages/css/bootstrap.css"/>">
<link rel="stylesheet" href="<c:url value="/pages/css/font-awesome.css"/>">
<link rel="stylesheet" href="<c:url value="/pages/css/icomoon.css"/>">
<link rel="stylesheet" href="<c:url value="/pages/css/styles.css"/>">
<link rel="stylesheet" href="<c:url value="/pages/css/mystyles.css"/>">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link href="<c:url value="/pages/css/input/fileinput.css"/>" media="all" rel="stylesheet" type="text/css" />
<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script src="<c:url value="/pages/js/input/fileinput.min.js"/>"></script>
<script src="<c:url value="/pages/js/input/fileinput_locale_uk.js"/>"></script>
<script src="<c:url value="/pages/js/modernizr.js"/>"></script>




<header id="main-header">
  <div class="header-top">
    <div class="container">
      <div class="row">
        <div class="col-md-3">
          <a class="logo" href="index.html">
            <%--<img src="<c:url value="/pages/images/login/logoEarth1.png" />" alt="Image Alternative text" title="Image Title" />--%>
          </a>
        </div>
        <div class="col-md-3 col-md-offset-2">
          <form class="main-header-search">
            <div class="form-group form-group-icon-right">
              <i class="form-control-feedback glyphicon glyphicon-search"></i>
              <input type="text" class="form-control">
            </div>
          </form>
        </div>

        <div class="col-md-4">
          <div class="top-user-area clearfix">
            <ul class="top-user-area-list list list-horizontal list-border">
              <li class="top-user-area-avatar">
                <a href="profile">
                  <img class="origin round" src="<c:url value="/pages/images/amaze_40x40.jpg"/>" alt="Image Alternative text" title="AMaze" />Hi, Julia</a>
              </li>
              <li><a href='<c:url value="/logout" />'>Sign Out</a>
              </li>

              <li class="top-user-area-lang nav-drop">
                <a href="#">
                  <img src="<c:url value="/pages/images/flag/uk.png"/>" alt="Image Alternative text" title="Image Title" />ENG<i class="glyphicon glyphicon-menu-down"></i>
                </a>
                <ul class="list nav-drop-menu">

                  <li>
                    <a title="Ukrainian" href="#">
                      <img src="<c:url value="/pages/images/flag/ua.png"/>" alt="Image Alternative text" title="Image Title" /><span class="right">UA</span>
                    </a>
                  </li>

                </ul>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="container">
    <div class="nav">
      <ul class="slimmenu" id="slimmenu">
        <li class="active"><a href="main.html">Home</a>
        </li>
        <li><a href="profile">Profile</a>
        </li>
        <li><a href="places.html">Places</a>

        </li>
        <li><a href="routes">Routes</a>
        </li>

      </ul>
    </div>
  </div>
</header>


