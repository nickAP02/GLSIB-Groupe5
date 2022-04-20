const element = document.querySelector(".trigger-swal");
var id = document.getElementById("#valDel");
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
      Swal.showLoading();
      return new Promise((resolve) => {
        '/category/delete/'+id
        });
        ))
    }
  })
});

