function fetchData() {
    const inputValue = document.getElementById('inputField').value;
    // 这里添加fetch请求的代码
    fetch('http://127.0.0.1:8080/get-meter-reading?meterID=' + inputValue)
        .then(response => response.json())
        .then(data => {
            console.log('返回的数字是:', data.reading);
            document.getElementById('result').textContent = data.reading;
        })
        .catch(error => {
            console.error('请求出错:', error);
            document.getElementById('result').textContent = '请求失败';
        });
}