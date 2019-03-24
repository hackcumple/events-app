<template>
    <div class="home" v-if="isLoading">
        <Loader/>
    </div>
    <div class="home" v-else>
        <Menubar/>
        <div class="wrapper-normal">

            <h1>Biuro rzeczy znalezionych</h1>
            <h2 class="where">Katowice, Galeria Rondo Sztuki, Rondo im. Jerzego Ziętka 2</h2>
            <div>
                <ul class="nearby-places-ul">
                    <li class="nearby-places-li" v-for="item in items">
                        <img class="nearby-places-img" :src= 'require("../static/" + item.Image)'  >
                        <div class="lost-found-description">{{ item.Name }}</div>
                    </li>
                </ul>
            </div>
            <h2 class="where">Dorbne ogłoszenia</h2>
            <div>
                <ul class="nearby-places-ul">
                    <li class="nearby-places-li" v-for="item in announcements">
                        <div>{{ item.Description }}</div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</template>

<script>
    import Loader from "@/components/Loader.vue";
    import Menubar from "@/components/Menubar.vue";

    export default {
        name: "lostandfound",
        components: {
            Loader,
            Menubar
        },
        data() {
            return {
                isLoading: true,
                items: [
                    {Name: 'Sony Xperia 10', Image:"lost1.jpg"},
                    {Name: 'Portfel', Image:"lost2.jpg"},
                    {Name: 'Motorola moto e5', Image:"lost3.jpg"},
                    {Name: 'Kurtka',Image:"lost4.jpg"}
                ],
                announcements: [
                    {Description: "Sprzedam: zapalniczki benzynowe. ZIPPO, RONSON, STAR, REMO, ANGEL, EUROJET, TRISTAR,HOLY HAWK. 884765432"},
                    {Description: "Uwaga. Przegrywanie kaset video VHS i innych na płyty DVD. 540873563"},
                    {Description: "Sprzedam Album Blue Ray Legenda Rock-a Black Sabbath Paranoi. 764523543"},
                    {Description: "Słuchawki Razer Kraken Mobile Neon RZ04-0140 niebieskie. 563214213"},
                    {Description: ""}

                ]


            };
        },
        created() {
        },
        mounted() {
            this.isLoading = false;
        }
    };
</script>

