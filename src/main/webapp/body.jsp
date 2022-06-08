<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="a" class="dao.ListProductDAO" scope="request"/>

<div class="row">
  <div class="leftcolumn">
  <c:forEach items="${a.search('')}" var="p">
    <div class="card">
      <h2>${p.getName()}</h2>
      <h5>${p.getType()} - ${p.getBrand()} - ${p.getPrice()}$</h5>
      <div class="fakeimg" style="height:200px;"><img alt="phone" src="${p.getSrc()}"/></div>
      <p>${p.getDescription()}</p>
    </div>
    </c:forEach>
  </div>
  
  <div class="rightcolumn">
    <div class="card">
      <h2>Shopping cart</h2>
      <div class="fakeimg" style="height:100px;">Cart</div>
      <p>Some text about shopping products</p>
    </div>
    <div class="card">
      <h3>Popular products</h3>
      <div class="fakeimg"><p>Image</p></div>
      <div class="fakeimg"><p>Image</p></div>
      <div class="fakeimg"><p>Image</p></div>
    </div>
    <div class="card">
      <h3>Banner</h3>
      <p>Some text..</p>
    </div>
  </div>
</div>