const fetch = require('node-fetch');
const moment = require('moment');

class jadwalSholat {
    constructor(kota, tanggal) {
        this.kota = kota
        this.tanggal = tanggal
    }

    async request() {
        const kota = this.kota
        const tanggal = this.tanggal
        const getData = new Promise(async function(resolve, reject) {
            fetch(`https://api.banghasan.com/sholat/format/json/jadwal/kota/${kota}/tanggal/${tanggal}`, {
                method: 'GET'
            })
            .then(res => res.json())
            .then(result => {
                return resolve(result.jadwal.data)
            })
            .catch(err => reject(err))
        })
        return getData;
    }

    async waktuSubuh() {
        const subuh = await this.request();
        return subuh.subuh
    }

    async waktuDzuhur() {
        const dzuhur = await this.request()
        return dzuhur.dzuhur
    }

    async waktuAshar() {
        const ashar = await this.request()
        return ashar.ashar
    }

    async waktuMaghrib() {
        const maghrib = await this.request()
        return maghrib.maghrib
    }

    async waktuIsya() {
        const isya = await this.request()
        return isya.isya
    }

    async hariIni() {
        const hari = await this.request()
        return hari.tanggal
    }
}

(async () => {
    const tanggal = moment().format("YYYY-MM-DD")
    const jadwal = new jadwalSholat("667", tanggal)

    console.log("=== Jadwal Sholat dan Imsakiyah ===")
    console.log("[+] Untuk daerah DKI Jakarta")
    console.log(`[+] ${await jadwal.hariIni()}\n`)
    console.log(`Subuh  : ${await jadwal.waktuSubuh()}`)
    console.log(`Dzuhur : ${await jadwal.waktuDzuhur()}`)
    console.log(`Ashar  : ${await jadwal.waktuAshar()}`)
    console.log(`Maghrib: ${await jadwal.waktuMaghrib()}`)
    console.log(`Isya   : ${await jadwal.waktuIsya()}`)
})();