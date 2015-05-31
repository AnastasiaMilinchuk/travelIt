<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<div>
  <footer id="main-footer">
    <div class="container">
      <div class="row row-wrap">
        <div class="col-md-4">
          <a class="logo" href="">
            <img src="<c:url value = "/pages/img/logo-invert.png"/>" alt="Image Alternative text" title="Image Title" />
          </a>
          <p class="mb20">TravelIt help you with planning of trips, sharing and saving of wonderful places</p>
        </div>

        <div class="col-md-4">
          <h4>Newsletter</h4>
          <form>
            <label>Enter your E-mail Address</label>
            <input type="text" class="form-control"/>
            <p class="mt5"><small>*We Never Send Spam</small>
            </p>
            <input type="submit" class="btn btn-primary" value="Subscribe"/>
          </form>
        </div>
        <%--<div class="col-md-2"></div>--%>
        <div class="col-md-4">
          <h4>Authors</h4>
          <h4 class="text-color">Artem Malinovskiy</h4>
          <h4 class="text-color">Anastasia Milinchuk</h4>
          <h4 class="text-color">Tanya Syagailo</h4>
          <h4 class="text-color">Julia Hrihorieva</h4>
          <h4 class="text-color">Nikita Orlov</h4>
        </div>

      </div>
    </div>
  </footer>
</div>