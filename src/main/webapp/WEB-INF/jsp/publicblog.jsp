<%@ include file="header.jsp"%>

<div class="container">
	<div style="padding: 40px 15px; text-align: center;">
		<div>
			<form action="${applicationScope['serverurl']}/user/publishsuccess.html">
				<div class="input-group">
					 <input type="text"
						class="form-control" placeholder="Title" name="title">
				</div>
				<textarea rows="20" cols="20" class="form-control" name="postblog"
					style="margin-bottom: 5px"></textarea>
				<button class="btn btn-lg btn-primary" type="submit"
					style="float: right">提交</button>
			</form>
		</div>
	</div>
</div>
<%@ include file="footer.jsp"%>