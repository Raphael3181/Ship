function htmldecode(value) { return $('<div/>').html(value).text(); }
function replacehtml() {
    var content;
    content = $("#psummary").html();
    content = htmldecode(content.replace(new RegExp("&amp;", 'g'), "&"));
    document.getElementById('psummary').innerHTML = "";
    $("#psummary").append(content);
    content = $("#parming").html();
    content = htmldecode(content.replace(new RegExp("&amp;", 'g'), "&"));
    document.getElementById('parming').innerHTML = "";
    $("#parming").append(content);
}