<div align="center">

# 🔀 Zamotaná slova

**Konzolová hra v Javě, ve které hádáš slova se zamíchanými písmeny.**

![Java](https://img.shields.io/badge/Java-25%2B-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ_IDEA-000000?style=for-the-badge&logo=intellijidea&logoColor=white)
![junior.guru](https://img.shields.io/badge/junior.guru-výzva-1755D1?style=for-the-badge)

[Jak se hraje](#-jak-se-hraje) · [Funkce](#-funkce) · [Spuštění](#-spuštění) · [Plány do budoucna](#-plány-do-budoucna) · [Zadání](#-zadání)

</div>

---

## 🎮 Jak se hraje

1. Vybereš si obtížnost – **snadná**, **střední** nebo **obtížná**.
2. Hra náhodně vybere slovo a zamíchá jeho písmena.
3. Napíšeš, jaké slovo to podle tebe původně bylo.
4. Hra ti ukáže, která písmena máš na správném místě, a připíše bod tobě, nebo počítači.
5. Pokračuješ dalším kolem, dokud tě to baví.

```text
Zahrajeme si spolu hru.
Z následujících možností si vyber jednu obtížnost:
1) snadná
2) střední
3) obtížná

Vlož odpověď:
2
Zamíchané slovo je: čakko
Co je původní slovo?
kočak
Tvůj návrh: "koč??" a to je ŠPATNĚ !

Kolik jsme měli kol: 1
SCORE ty vs. pocitac je: 0:1
Chceš si hru zopakovat a/n:
```

## 🚀 Funkce

| Obtížnost | Délka slov | Příklady |
| --- | --- | --- |
| 🟢 Snadná | 3–4 písmena | pes, voda, oheň |
| 🟡 Střední | 5–7 písmen | kočka, jahoda, počítač |
| 🔴 Obtížná | 8 a více písmen | čokoláda, krokodýl, dobrodružství |

### Základní řešení

- [x] Seznam slov
- [x] Náhodný výběr slova
- [x] Zamíchání písmen
- [x] Zadání odpovědi uživatelem
- [x] Vyhodnocení odpovědi

### Rozšíření

- [x] Více kol
- [x] Skóre
- [ ] Časový limit
- [x] Nápověda
- [x] Různé obtížnosti
- [ ] Parametry při spuštění (počet kol, obtížnost `easy` / `hard`)
- [ ] Vlastní seznam slov načítaný ze souboru

## 🔮 Plány do budoucna

- ⏱️ **Odpočet času** – v budoucnu bych ze zadání rád přidal ještě odpočet, aby měl hráč na uhodnutí slova jen omezený čas.

## 📖 Spuštění

> [!NOTE]
> Vyžaduje **Javu 25** nebo novější.

```bash
# 1. Kompilace všech souborů
javac -d out src/*.java

# 2. Spuštění hry
java -cp out Main
```

Případně lze hru spustit i bez samostatné kompilace:

```bash
java src/Main.java
```

## 📂 Struktura projektu

```text
src/
├── Main.java      # vstupní bod, herní smyčka a komunikace s hráčem
├── Service.java   # herní logika – výběr slova, zamíchání, vyhodnocení a skóre
└── Words.java     # seznamy slov pro obtížnosti EASY, MEDIUM, HARD
```

## 🛠 Technologie

- **Java** – jádro aplikace
- **IntelliJ IDEA** – vývojové prostředí

## 📝 Zadání

<details>
<summary><b>Mini projektová výzva: Zamíchané slovo</b> (kliknutím rozbalíš)</summary>

<br>

> Vytvoř malou hru, ve které budeš hádat slova, jejichž písmena se zamíchala.
>
> ### Zadání
>
> Program náhodně vybere slovo ze seznamu, zamíchá jeho písmena a zobrazí ho v konzoli. Uživatel musí uhodnout původní slovo.
>
> Například:
>
> ```text
> Zamíchané slovo: ČAKKO
> Co je původní slovo?
> > KOČKA
> Správně!
> ```
>
> ### Co by mělo mít základní řešení
>
> Hra by měla:
>
> - obsahovat seznam slov
> - náhodně vybrat jedno slovo
> - zamíchat jeho písmena
> - nechat uživatele zadat odpověď
> - vyhodnotit, zda byla odpověď správná
>
> ### Co můžeš přidat navíc
>
> - více kol
> - skóre
> - časový limit
> - nápovědu
> - různé obtížnosti
> - parametr při spuštění, například počet kol nebo obtížnost `easy` / `hard`
> - vlastní seznam slov načítaný ze souboru
>
> Těším se na vaše zamotaná slova

</details>

## 🤖 Transparentnost využití AI

Tento soubor README vytvořil AI asistent [Claude Code](https://claude.com/claude-code) (Anthropic). Kód hry s pomocí AI vytvořen nebyl.

---

<div align="center">

*Projekt vznikl jako mini projektová výzva v komunitě [junior.guru](https://junior.guru/).*

</div>
