import fontawesome from '@fortawesome/fontawesome'
import regular from '@fortawesome/fontawesome-free-regular'
import solid from '@fortawesome/fontawesome-free-solid'
import brands from '@fortawesome/fontawesome-free-brands'

fontawesome.library.add(regular)
fontawesome.library.add(solid)
fontawesome.library.add(brands)

import * as $ from 'jquery';
import 'bootstrap'
import './app.scss'

document.addEventListener("DOMContentLoaded", (event) => {
    console.log("DOM fully loaded and parsed... FRONTEND");
    $('[data-toggle="tooltip"]').tooltip()
    $('.alert').show('slow')
});