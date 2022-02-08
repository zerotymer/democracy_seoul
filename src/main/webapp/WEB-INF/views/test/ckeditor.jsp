<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<HTML>
 <HEAD>
  <TITLE> CKEditor5 Sample </TITLE>
  

 </HEAD>
 <BODY>
 	<form action="/test/print.do" method="post">
    	<textarea name="content" id="editor"></textarea>
    	<input type="submit" value="도라에몽"/>
    </form>
    <script src="https://cdn.ckeditor.com/ckeditor5/11.0.1/classic/ckeditor.js"></script>
    <script>
        ClassicEditor
            .create( document.querySelector( '#editor' ), {
                ckfinder: {
                    uploadUrl: '/ajax/imageUpload.do'
                }
            })
            .catch( error => {
                console.error( error );
            });
    </script>
 </BODY>
</HTML>
