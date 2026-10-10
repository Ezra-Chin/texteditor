public class FindPlugin implements Plugin{
   @Override 
   public void start(EditorApi api){
        api.addButton("Find", () -> find(api)); 
        api.addFunctionKeyListener(key -> {
            if(key == 3){
                find(api);
            }
        })
   
   }
   private void find(EditorApi api ) {

   }
}
