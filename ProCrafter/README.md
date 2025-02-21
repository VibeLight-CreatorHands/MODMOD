# ProCrafter-1.20.1Neo
ProCrafter-1.20.1 NEoForge Version for Yuyuto.

# 欠損リソース(一部)
- assets/procrafter/textures/gui/skill_tree.png
- assest/procrafter/textures/gui/magic_machine_gui.png
- assets/procrafter/textures/gui/skill_attack.png（16x16 の攻撃特化型スキルのスキルアイコン）
- assets/procrafter/textures/gui/skill_defence.png（防衛・守備強化型スキルのスキルアイコン）
- assets/procrafter/textures/gui/skill_jump.png（16x16 ピクセルの PNG 画像）

他にも多数あり、とんでもないことになっています。
Source installation information for modders
-------------------------------------------
This code follows the Minecraft Forge installation methodology. It will apply
some small patches to the vanilla MCP source code, giving you and it access 
to some of the data and functions you need to build a successful mod.

Note also that the patches are built against "un-renamed" MCP source code (aka
SRG Names) - this means that you will not be able to read them directly against
normal code.

Setup Process:
==============================

Step 1: Open your command-line and browse to the folder where you extracted the zip file.

Step 2: You're left with a choice.
If you prefer to use Eclipse:
1. Run the following command: `./gradlew genEclipseRuns`
2. Open Eclipse, Import > Existing Gradle Project > Select Folder 
   or run `gradlew eclipse` to generate the project.

If you prefer to use IntelliJ:
1. Open IDEA, and import project.
2. Select your build.gradle file and have it import.
3. Run the following command: `./gradlew genIntellijRuns`
4. Refresh the Gradle Project in IDEA if required.

If at any point you are missing libraries in your IDE, or you've run into problems you can 
run `gradlew --refresh-dependencies` to refresh the local cache. `gradlew clean` to reset everything 
(this does not affect your code) and then start the process again.

Mapping Names:
=============================
By default, the MDK is configured to use the official mapping names from Mojang for methods and fields 
in the Minecraft codebase. These names are covered by a specific license. All modders should be aware of this
license, if you do not agree with it you can change your mapping names to other crowdsourced names in your 
build.gradle. For the latest license text, refer to the mapping file itself, or the reference copy here:
https://github.com/MinecraftForge/MCPConfig/blob/master/Mojang.md

Additional Resources: 
=========================
Community Documentation: https://docs.minecraftforge.net/en/1.20.1/gettingstarted/
LexManos' Install Video: https://youtu.be/8VEdtQLuLO0
Forge Forums: https://forums.minecraftforge.net/
Forge Discord: https://discord.minecraftforge.net/

# General contents
**「ProCrafter」の5つの主軸システム** 

### **🔹 ProCrafter の 5 つの主軸コンテンツ**
1. **農業、工業、運送を主軸とした終わらない独自産業**  
   - 作物・畜産・自動農業・機械化システム  
   - 自動工場、生産ライン、物流システム  

2. **魔法精霊学とその上位互換学問**  
   - 精霊や魔法の研究・発展  
   - 物理学や科学と組み合わせた独自魔法体系  

3. **驚愕する超規模探検世界**  
   - 新しいバイオーム、次元、探索要素  
   - 生成型のダンジョン、隠された遺跡  

4. **ハックアンドスラッシュを基本とした戦闘要素の追加**  
   - 格闘・アクション・FPSなど多彩な戦闘スタイル  
   - スキルツリー、装備カスタマイズ、ボス戦  

5. **カスタムディメンションの実装で、配布ワールドを新たなディメンションとして導入できる**  
   - 既存のマップを「次元」として統合可能  
   - 配信向けのワールドやMODパック連携  

**🎯 そして現在のエンドコンテンツ「次元展開型モバイルフォートレス」は、主に③④⑤のシステムと深く関わる要素になっています！**  
もし全体のバランスを考えるなら、工業・魔法・戦闘・探索のそれぞれと拠点をどう連携させるかを考えると良さそうですね！

# End contents1
移動拠点や建築の保存・展開システムを組み合わせた「ストリーマー専用の多機能移動拠点（キャンプシステム）」
---

## **🔹 ストリーマー向けエンドコンテンツ案：「次元展開型モバイルフォートレス」**
**プレイヤーが「移動可能な拠点」を持ち、建築を保存・展開できるストリーマー向け特殊システム。**  
リアルタイムの配信企画やイベントに活かしやすく、視聴者参加型のコンテンツにも対応可能。

---

### **🛠 概要**
- **拠点を異次元空間に保存し、好きな場所に展開できる**
- **乗り物として移動可能な拠点**（ロボット形態、戦艦形態など）
- **視聴者参加型の要素**（視聴者が拠点に影響を与える仕組み）
- **PvPvEや探索との連携**（戦闘時に要塞化、冒険時に補給基地化）

---

## **🔹 基本システム**
| **システム名** | **概要** |
|--------------|----------------------------|
| **1. 建築の異次元保存** | プレイヤーが作った拠点を次元空間に保存し、どこでも展開できる |
| **2. モバイル拠点（変形）** | 飛行船、戦艦、ロボットなどに変形し移動可能 |
| **3. プレイヤーの陣営化** | ストリーマーが拠点を作り、視聴者が支援や妨害できる |
| **4. PvPvEと連携** | モンスター襲撃時に拠点を要塞化、ボス戦に対応 |
| **5. 自動生成・拡張** | AIでダンジョン化、拡張オプション追加 |
| **6. 視聴者インタラクション** | Twitchチャットからイベントを発生させる |

---

## **🔹 具体的な拠点の形態**
| **形態** | **説明** |
|----------|-------------------------------|
| **異次元キャンプ** | コンパクトな空間に拠点を収納し、どこでも展開可能 |
| **移動要塞（戦艦型）** | 巨大な移動基地。PvPや視聴者イベント向け |
| **変形ロボット** | 建築を格納し、必要に応じてロボットとして展開 |
| **飛行拠点** | 浮遊型の基地で、空中戦や探索に適応 |

---

## **🔹 機能詳細**
### **1️⃣ 拠点の異次元保存＆展開**
- **建築を専用アイテムでスキャンし、異次元空間に保存**
- **必要な時に「展開アイテム」を使用して任意の場所に呼び出せる**
- **拠点のカスタマイズが可能（追加建築、モジュール装備）**

### **2️⃣ モバイル拠点（変形機構）**
- **拠点が変形し、乗り物として機能**
  - 飛行型：浮遊都市のように移動
  - 戦艦型：砲撃や防御システムを持つ
  - ロボット型：直接戦闘が可能
- **移動時にエネルギーを消費し、補給が必要**

### **3️⃣ 視聴者インタラクション**
- **TwitchやYouTubeのチャットと連携**
  - 視聴者が「/boost」「/raid」などのコマンドを送信
  - 一定数の投票で拠点にバフやデバフが発生
  - 例：「敵襲来」「補給物資」「建築モジュールの解放」

### **4️⃣ PvPvEとの連携**
- **拠点が戦闘モードに変形し、モンスターや他プレイヤーと対戦**
- **ダンジョン攻略中に拠点を召喚して補給や回復が可能**
- **ボス戦時に拠点を防衛要塞として使用**

### **5️⃣ AI生成ダンジョン**
- **拠点が新しいエリアを自動生成**
- **プレイヤーの行動に応じてマップが拡張**
- **ストリーマーが「視聴者イベント」として新エリアを開放**

---

## **🔹 どんな配信向き？**
| **配信スタイル** | **適用例** |
|----------------|------------------------------|
| **視聴者参加型** | 視聴者が拠点の拡張やイベントを操作 |
| **PvPvEストリーマー** | 他のストリーマーと拠点を使った戦闘 |
| **建築系配信** | クリエイティブで巨大な拠点を制作し、次元展開 |

# End contents2
## ネクルミナス・コーデックス

---

### 概要
- 禁断の魔導書と言われている一連の大魔法や次世代の大きな技術、歴史などを詰め込んだ一連の書物「ProCrafter-SkillSpellBooks」の1つ。
- 主に世界を創造・破壊すると言われているヤバいやつ。
**クライアント上でのSkillSpell内に、1つずつ導入可能にする。
