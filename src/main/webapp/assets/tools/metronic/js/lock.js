var Lock = function () {

    return {
        //main function to initiate the module
        init: function () {

             $.backstretch([
		        "../../assets/tools/metronic/image/bg/1.jpg",
		        "../../assets/tools/metronic/image/bg/2.jpg",
		        "../../assets/tools/metronic/image/bg/3.jpg",
		        "../../assets/tools/metronic/image/bg/4.jpg"
		        ], {
		          fade: 1000,
		          duration: 8000
		      });
        }

    };

}();