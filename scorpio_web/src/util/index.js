let throttle = function throttle(func, delay) {
    let prev = Date.now();
    console.log('1')
    console.log(prev)
    console.log(Date.now())
    return function () {
        let context = this;
        let args = arguments;
        let now = Date.now();
        console.log('4')
        if (now - prev >= delay) {
            console.log('6')
            func.apply(context, args);
            prev = Date.now();
        }
    }
}
export default throttle