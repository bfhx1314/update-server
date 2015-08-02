//跨域上传回调解决方案,ie8+
(function(){
    function messageHandler(event){
        var host='';//服务器的域名
        if (event.origin !== host){
            return;
        }
        eval("("+event.data+")");
    }
    if (typeof window.addEventListener != 'undefined') {
        window.addEventListener('message', messageHandler, false);
    } else if (typeof window.attachEvent != 'undefined') {
        window.attachEvent('onmessage', messageHandler);
    }
})();