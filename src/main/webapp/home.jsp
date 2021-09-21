<jsp:include page='header.jsp'>
    <jsp:param name="title" value="Home"/>
</jsp:include>

<h1>Home</h1>
<div class="card">
  <h5 class="card-header">Featured</h5>
  <div class="card-body">
    <h5 class="card-title">Special title treatment</h5>
    <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
    <a href="#" class="btn btn-primary">Go somewhere</a>
  </div>
</div>

</br>
<button type="button" class="btn btn-primary position-relative">
  Inbox
  <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
    99+
    <span class="visually-hidden">unread messages</span>
  </span>
</button>

</br>
</br>
<button type="button" class="btn btn-primary">
  Notifications <span class="badge bg-danger">4</span>
</button>

<jsp:include page='footer.jsp'></jsp:include>