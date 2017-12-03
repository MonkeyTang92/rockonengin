<script src="https://cdn.bootcss.com/ppdAdmin/lib/lte/2.3.11/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!--Bootstrap 3.3.6-->
<script src="https://cdn.bootcss.com/ppdAdmin/lib/lte/2.3.11/bootstrap/js/bootstrap.min.js"></script>
<#-- fastclick 1.0.6-->
<script src="https://cdn.bootcss.com/ppdAdmin/lib/lte/2.3.11/plugins/fastclick/fastclick.js"></script>
<script src="https://cdn.bootcss.com/ppdAdmin/lib/lte/2.3.11/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<script src="https://cdn.bootcss.com/ppdAdmin/lib/lte/2.3.11/plugins/sparkline/jquery.sparkline.min.js"></script>
<script src="https://cdn.bootcss.com/ppdAdmin/lib/lte/2.3.11/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="https://cdn.bootcss.com/ppdAdmin/lib/lte/2.3.11/plugins/chartjs/Chart.min.js"></script>
<script>
    $.fn.serializeObject = function () {
        var o = {};
        var a = this.serializeArray();
        $.each(a, function () {
            if (o[this.name]) {
                if (!o[this.name].push) {
                    o[this.name] = [o[this.name]];
                }
                o[this.name].push(this.value || '');
            } else {
                o[this.name] = this.value || '';
            }
        });
        return o;
    };
</script>