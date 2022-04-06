const element = document.querySelector(".trigger-swal");
element.addEventListener("click", function message() {
  Swal.fire({
    title: 'Voulez-vous supprimer cette catégorie ?',
    buttonsStyling: true,
    showCancelButton: true,
    customClass: {
      confirmButton: 'btn btn-primary btn-lg',
      cancelButton: 'btn btn-danger btn-lg',
      loader: 'custom-loader'
    },
    loaderHtml: '<div class="spinner-border text-primary"></div>',
    preConfirm: () => {
      Swal.showLoading()
      return new Promise((resolve) => {
      $.ajax({
          var id = $(this).attr('id');
          var parent = $(this).parent().parent();
          type: "POST",
          url: "http://localhost:8080/category/delete/" + id,
          cache: false,
          success: function() {
              parent.fadeOut('slow', function() {
                  $(this).remove();
              });
              location.reload(true)
          },
          error: function() {
              $('#err').html('<span style=\'color:red; font-weight: bold; font-size: 30px;\'>Error deleting record').fadeIn().fadeOut(4000, function() {
                  $(this).remove();
              });
          }
        });
        ))
    }
  })
});

