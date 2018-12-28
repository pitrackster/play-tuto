// bootstrap js
import 'bootstrap'

document.addEventListener("DOMContentLoaded", (event) => {
    console.log("DOM fully loaded and parsed... COMMON")
    $('[data-toggle="tooltip"]').tooltip()
    $('.alert').show('slow')
})