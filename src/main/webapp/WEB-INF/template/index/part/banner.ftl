<div class="banner">
    <div class="banner_container">
        <div class="wmuSlider example1">
            <div class="wmuSliderWrapper">
                <article style="position: absolute; width: 100%; opacity: 0;">
                    <img src="<@c.resource "images/index-banner.jpg"/>" width="100%" height="auto">
                    <div class="clearfix"></div>
                </article>
                <article style="position: relative; width: 100%; opacity: 1;">
                    <img src="<@c.resource "images/campus-banner.jpg"/>" width="100%" height="auto">
                    <div class="clearfix"></div>
                </article>
            </div>
            <a class="wmuSliderPrev">Previous</a><a class="wmuSliderNext">Next</a>
            <script src="<@c.resource "js/jquery.wmuSlider.js"/>"></script>
            <script>
            $('.example1').wmuSlider();
            </script>
        </div>
    </div>
</div>