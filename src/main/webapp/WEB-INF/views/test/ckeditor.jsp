<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<HTML>
 <HEAD>
  <TITLE> CKEditor5 Sample </TITLE>
  
  <script src="https://cdn.ckeditor.com/ckeditor5/11.0.1/classic/ckeditor.js"></script>
 </HEAD>
 <BODY>
    <textarea name="content" id="editor"></textarea>
    <script>
    ClassicEditor
        .create( document.querySelector( '#editor' ), {
            // 제거 하고싶은 플러그인 (배열)
             removePlugins: [ 'ImageUpload' ]
        } )
        .catch( error => {
            console.error( error );
        } );
    </script>
 </BODY>
</HTML>
