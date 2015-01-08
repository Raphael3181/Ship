function activate(fleet) {
    if (fleet != 0) {
        document.getElementById('lihome').removeAttribute('class');
        document.getElementById('lifleet' + fleet).setAttribute('class', 'active');
    } else document.getElementById('lihome').setAttribute('class', 'active');
    var cnt = 1, lifleet;
    while ((lifleet = document.getElementById('lifleet' + cnt)) != null) {
        if (cnt != fleet) lifleet.removeAttribute('class'); cnt++;
    }
}