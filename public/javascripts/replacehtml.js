function htmldecode(value) { return $('<div/>').html(value).text(); }
function replacehtml() {
    var content;
    content = $("#psummary").html();  //значение абзаца описания корабля
    content = htmldecode(content.replace(new RegExp("&amp;", 'g'), "&")); //декодируем html
    document.getElementById('psummary').innerHTML = ""; //очищаем значение абзаца
    $("#psummary").append(content);
    content = $("#parming").html();
    content = htmldecode(content.replace(new RegExp("&amp;", 'g'), "&"));
    document.getElementById('parming').innerHTML = "";
    $("#parming").append(content);
}