<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<title>产品管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<link rel="stylesheet" href="<%=basePath %>/common/ace/assets/css/jquery-ui.css" />
<link rel="stylesheet" href="<%=basePath %>/common/ace/assets/css/datepicker.css" />
<link rel="stylesheet" href="<%=basePath %>/common/ace/assets/css/ui.jqgrid.css" />
<link rel="stylesheet" href="<%=basePath %>/common/ace/assets/css/dropzone.css" />
<!-- ajax layout which only needs content area -->
	<!-- <div class="page-header">
							<h1>
								jqGrid
								<small>
									<i class="ace-icon fa fa-angle-double-right"></i>
									Dynamic tables and grids using jqGrid plugin
								</small>
							</h1>
	</div> -->
	<!-- /.page-header -->


<div class="row">
	<div class="col-xs-12">
		<!-- PAGE CONTENT BEGINS -->

		<table id="grid-table-product"></table>

		<div id="grid-pager-product"></div>
		
		<script type="text/javascript">
			var $path_base = "../..";//in Ace demo this will be used for editurl parameter
		</script>

		<!-- PAGE CONTENT ENDS -->
	</div><!-- /.col -->
</div><!-- /.row -->



<!-- add -->
<div  id="productmodal" class="modal fade bs-example-modal-lg"  role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
        <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">
				<i class="ace-icon fa fa-hand-o-right icon-animated-hand-pointer blue"></i> 添加产品
			</h4>
	     </div>
      <div class="modal-body">
             <div class="row">
             	<form id="productform" class="form-horizontal" role="form">
		             		<!-- #section:elements.form -->
					<div class="form-group">
						<label class="col-sm-2 control-label no-padding-right" > 产品编号： </label>
		
						<div class="col-sm-4">
							<input name="productNo" type="text"  placeholder="产品编号" class="col-xs-10 col-sm-9" />
						</div>
						<label class="col-sm-2 control-label no-padding-right" > 产品名称 ：</label>
						<div class="col-sm-4">
							<input name="productName" type="text"  placeholder="产品名称" class="col-xs-10 col-sm-9" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label no-padding-right" > 价格： </label>
						<div class="col-sm-4">
							<input name="price" type="text"  placeholder="价格" class="col-xs-10 col-sm-9" />
						</div>
						<label class="col-sm-2 control-label no-padding-right" > 颜色： </label>
						<div class="col-sm-4">
							<input name="color" type="text"  placeholder="颜色" class="col-xs-10 col-sm-9" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label no-padding-right" > 品牌： </label>
						<div class="col-sm-4">
							<select name="brand" class=" col-xs-10 col-sm-9"   data-placeholder="选择一个品牌">
										<option value="0"> 0 </option>
										<option value="1">Alabama1</option>
										<option value="2">Alaska2</option>
										<option value="3">Arizona3</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label no-padding-right" > URL： </label>
						<div class="col-sm-10">
							<input name="url" type="text"  placeholder="URL" class="col-xs-10 col-sm-9" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label no-padding-right" > 引导图： </label>
						<div class="col-sm-10">
							<input name="url" type="text"  placeholder="URL" class="col-xs-10 col-sm-9" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label no-padding-right" > 引导图： </label>
						<div class="col-sm-10">
							<input name="guideMap" type="text"  placeholder="引导图路径" class="col-xs-10 col-sm-9" />
						</div>
					</div>
             </form>
             </div>
             <div class="row">
             <!--  <form id="guideform" class="form-horizontal" role="form" >
             	<div class="form-group">
						<label class="col-sm-2 control-label no-padding-right" > 引导图： </label>
						<div class="col-sm-10">
							<input name="url" type="text"  placeholder="URL" class="col-xs-10 col-sm-9" />
						</div>
				</div>
				</form> -->
				<div class="col-xs-8 col-md-offset-2">
					<form action="/ShopSys/ckeditorUploadAction_uploadGuideImg.action" class="dropzone" id="dropzone">
						<div class="fallback">
							<input name="guideImg"  id="guideImg" type="file"  />
						</div>
					</form>
				</div>
				
             </div>
             <!-- 详细信息 -->
             <div class="row">
             	<div class="form-group">
					      <label style="margin-left:20px;" class="col-sm-12 " for="form-field-1">详细信息： </label>
						<div class="col-sm-12">
							<textarea name="detailInfo" id="editor1" rows="20" cols="80">
				                This is my textarea to be replaced with CKEditor.
				            </textarea>
			            </div>
					</div>
             </div>
             
           
			<script src="<%=basePath %>/common/ckeditor/ckeditor.js"></script>	
	
		   <!--  <div class="row">
		    	 <h4>详细信息：</h4>
				 <textarea name="editor1" id="editor1" rows="20" cols="80">
	                This is my textarea to be replaced with CKEditor.
	            </textarea>
		    </div>/.row -->
	
	         <script>
	                // Replace the <textarea id="editor1"> with a CKEditor
	                // instance, using default configuration.
	                CKEDITOR.replace( 'editor1' );
	            
	            //解决bootrap模态框和ckeditor弹窗的冲突    
		        $.fn.modal.Constructor.prototype.enforceFocus = function () {
		            modal_this = this;
		            $(document).on('focusin.modal', function (e) {
		                if (modal_this.$element[0] !== e.target && !modal_this.$element.has(e.target).length
		                &&
		                !$(e.target.parentNode).hasClass('cke_dialog_ui_input_select') && !$(e.target.parentNode).hasClass('cke_dialog_ui_input_text')) {
		                    modal_this.$element.focus();
		                }
		            });
        		};
	         </script>
       
      </div>
      <div class="modal-footer" style="height:55px;">
	        <button type="button" class="btn btn-white btn-info btn-round" data-dismiss="modal">
	        	<i class="ace-icon fa fa-times  red2"></i>取消
	        </button>
	        <button id="saveproduct" type="button" class="btn btn-white btn-info btn-round" >
	        	<i class="ace-icon fa fa-floppy-o  blue"></i>保存
	        </button>
	        
      </div>
    </div>
  </div>
</div>





<!-- page specific plugin scripts -->
<script src="<%=basePath %>/js/back/product.js"></script>
<script type="text/javascript">
	var scripts = [null,"<%=basePath %>/common/ace/assets/js/dropzone.js", null]
	$('.page-content-area').ace_ajax('loadScripts', scripts, function() {
	  //inline scripts related to this page
		 jQuery(function($){
	
	try {
	  Dropzone.autoDiscover = false;
	  var myDropzone = new Dropzone("#dropzone" , {
	    paramName: "guideImg", // The name that will be used to transfer the file
	    maxFilesize:2.0, // MB
	
		addRemoveLinks : true,
		dictDefaultMessage :
		'<span class="bigger-150 bolder"></span>  \
		<span class="smaller-80 grey">上传引导图</span> <br /> \
		<i class="upload-icon ace-icon fa fa-cloud-upload blue fa-3x"></i>'
	,
		dictResponseError: '上传失败！',
		
		//change the previewTemplate to use Bootstrap progress bars
		previewTemplate: "<div class=\"dz-preview dz-file-preview\">\n  <div class=\"dz-details\">\n    <div class=\"dz-filename\"><span data-dz-name></span></div>\n    <div class=\"dz-size\" data-dz-size></div>\n    <img data-dz-thumbnail />\n  </div>\n  <div class=\"progress progress-small progress-striped active\"><div class=\"progress-bar progress-bar-success\" data-dz-uploadprogress></div></div>\n  <div class=\"dz-success-mark\"><span></span></div>\n  <div class=\"dz-error-mark\"><span></span></div>\n  <div class=\"dz-error-message\"><span data-dz-errormessage></span></div>\n</div>"
	  });
	  
	   $(document).one('ajaxloadstart.page', function(e) {
			try {
				myDropzone.destroy();
			} catch(e) {}
	   });
	
	} catch(e) {
	  alert('Dropzone.js does not support older browsers!');
	}
	
	});
	});
</script>
