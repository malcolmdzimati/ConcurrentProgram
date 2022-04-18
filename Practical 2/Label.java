class Label implements Comparable <Label> {
    int counter;
    int id;

     Label () {
            counter = 0;
                String name=Thread.currentThread().getName();
            try{
                id = Integer.parseInt(String.valueOf(name.charAt(name.length()-1)));
           }catch(NumberFormatException ex){

           }
    }

    Label(int c) {
            counter = c;
            String name=Thread.currentThread().getName();
            try{
                 id = Integer.parseInt(String.valueOf(name.charAt(name.length()-1)));
            }catch(NumberFormatException ex){

            }
       }

    static int max(Label[] labels) {
            int c = 0;
            for (Label label : labels) {
                    c = Math.max(c, label.counter );
            }
            return c;
    }

    public int compareTo(Label other) {
            if (this.counter < other.counter || (this.counter == other.counter && this.id < other.id)) {
                    return -1;
            } else if (this.counter > other.counter) {
                    return 1;
            } else {
                    return 0;
            }
    }

}