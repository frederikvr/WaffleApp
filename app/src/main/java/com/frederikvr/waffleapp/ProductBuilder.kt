package com.frederikvr.waffleapp

object ProductBuilder {
    fun getProducts(): List<Product> {
        val productList = mutableListOf<Product>()

/* THIS WAS EXAMPLE CODE
        productList.add(
            Product(
                "A bieslook",
                "A bieslook",
                2.0,
                "aard",
                0,
                "B CHAMP",
                "B CHAMP",
                1.2,
                "blader",
                0
        )
        productList.add(
            Product(
                "HartigOfZoet",
                "HartigOfZoet",
                2.5,
                "aard",
                0,
                "B CHAMP",
                "COLA ZERO",
                1.0,
                "frisdrank",
                0
            )
        )
*/

/* THIS IS PARSED FROM EXCEL */
        productList.add(Product("A bieslook en peterselie","A bieslook",2.00,"aard",0,"B champignons","B champ",3.00,"blader",0))
        productList.add(Product("A rozemarijn ","A parmes",2.00,"aard",0,"B courgette","B courg",3.00,"blader",0))
        productList.add(Product("A gorgonzola","A gorg",2.30,"aard",0,"B gehakt","B gehakt",3.80,"blader",0))
        productList.add(Product("A olijven","A olijf",2.30,"aard",0,"B gerookte ham","B Ham",3.80,"blader",0))
        productList.add(Product("A gerookte ham","A ham",2.50,"aard",0,"B appel","B appel",3.00,"blader",0))
        productList.add(Product("A chorizzo","A chorr",2.50,"aard",0,"B chocolade","B Chocol",3.00,"blader",0))
        productList.add(Product("A kippengehakt","A kip",2.80,"aard",0,"Vanille","Vanille",2.00,"vanille",0))
        productList.add(Product("A gerookte zalm","A zalm",3.00,"aard",0,"Coca-Cola","Cola",1.50,"frisdrank",0))
        productList.add(Product("Big Chocolate","Chocolat",2.30,"ijsjes",0,"Cola zero","Cola 0",1.50,"frisdrank",0))
        productList.add(Product("Cornet d'amour","Cornet",2.00,"ijsjes",0,"Ice - Tea","Tea",1.50,"frisdrank",0))
        productList.add(Product("Maxi vanille","Vanille",1.20,"ijsjes",0,"Fanta","Fanta",1.50,"frisdrank",0))
        productList.add(Product("Satelite","Satelite",1.00,"ijsjes",0,"Appelsap","Appel",2.00,"frisdrank",0))
        productList.add(Product("Expresso","Expresso",1.80,"koffie",0,"Minute Maid","Appels",2.50,"frisdrank",0))
        productList.add(Product("Expresso melk","Expr M",2.00,"koffie",0,"Plat water","Plat w",1.50,"frisdrank",0))
        productList.add(Product("Lungo","Lungo",2.00,"koffie",0,"Spuitwater","Spuitw",1.50,"frisdrank",0))
        productList.add(Product("Lungo melk","Lungo M",2.20,"koffie",0,"Cécémel","Cecemel",2.00,"frisdrank",0))
        productList.add(Product("Deca","Deca",2.00,"koffie",0,"Jupiler","Pint",2.00,"bier",0))
        productList.add(Product("Deca melk","Deca M",2.20,"koffie",0,"Wijn, Wit","Wit",2.50,"wijn",0))
        productList.add(Product("Yellow label","Yellow",1.50,"thee",0,"Wijn, Rood","Rood",2.50,"wijn",0))
        productList.add(Product("Green tea","Green",1.50,"thee",0,"","",0.00,"",0))
        productList.add(Product("Rozenbottel","Rozenb",1.50,"thee",0,"","",0.00,"",0))


        return productList
    }
}