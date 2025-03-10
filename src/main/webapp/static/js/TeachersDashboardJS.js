
document.addEventListener("DOMContentLoaded", function () {
  const sidebar = document.getElementById("sidebar");
  const content = document.getElementById("content");
  const sidebarHeader = document.querySelector(".sidebar-header");

  function toggleSidebar() {
    if (window.innerWidth <= 768) {
      sidebar.classList.toggle("expanded");
      content.classList.toggle("sidebar-expanded");
    } else {
      sidebar.classList.toggle("collapsed");
      content.classList.toggle("expanded");
    }
  }

  sidebarHeader.addEventListener("click", toggleSidebar);

  // Handle window resize
  window.addEventListener("resize", function () {
    if (window.innerWidth <= 768) {
      sidebar.classList.remove("collapsed");
      content.classList.remove("expanded");
      if (!sidebar.classList.contains("expanded")) {
        sidebar.classList.remove("expanded");
        content.classList.remove("sidebar-expanded");
      }
    } else {
      sidebar.classList.remove("expanded");
      content.classList.remove("sidebar-expanded");
    }
  });
});
