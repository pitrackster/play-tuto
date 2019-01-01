// import bootstrap js
import 'bootstrap'

document.addEventListener('DOMContentLoaded', (event) => {
  console.log('DOM fully loaded and parsed... COMMON', event)
  $('[data-toggle="tooltip"]').tooltip()
  $('.alert').show('slow')
})
