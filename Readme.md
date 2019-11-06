Оптимизации в GraalVM и Truffle
---
1. **Partial evaluation** (@CompilationFinal ~ **BranchProfile** class in Truffle)
	+ Презентация Oracle, слайд 23, ~22мин
	+ Олег Шелаев ссылка внизу ~ 45мин
	+ Проекция Футамура
	+ Смешанные вычисления Ершов
2. **Condition Profile for Branch** (**ConditionProfile** class)
	+ Презентация Oracle, слайд 25, ~30мин
3. **Assumption**
	+ Презентация Oracle, слайд 27, ~33мин
	+ Олег Шелаев ссылка внизу ~ 47мин
4. **Specialization**
	+ Олег Шелаев ссылка внизу ~ 49мин
	+ Презентация Oracle, слайд 29, ~36мин
---
Полезные аннотации в Truffle
---
+ **BrunchProfile** - указываем компилятору ветки, которые встречаются реже всего
+ **ConditionProfile** - тоже самое в if/else
+ **ExplodeLoop** - Execute all child statements. The annotation {@link ExplodeLoop} triggers full unrolling of
                    the loop during compilation. This allows the {@link SLStatementNode#executeVoid} method of
                    all children to be inlined.  
                    *Example: SLBlockNode.java*  
---
Источники
---
**Установка GraalVM**  
https://gist.github.com/ricardozanini/fa65e485251913e1467837b1c5a8ed28

**Implement your language**  
https://www.graalvm.org/docs/graalvm-as-a-platform/implement-language/#run-simplelanguage-using-command-line

**Олег Шелаев — Суперкомпиляция, partial evaluation, проекции Футамуры**  
https://www.youtube.com/watch?v=C5fATKdVxZ0

**Презентация от Oracle**  
https://www.youtube.com/watch?v=FJY96_6Y3a4&feature=youtu.be 

**Tutorial: Write Lisp Compiler**  
http://cesquivias.github.io/blog/2014/12/02/writing-a-language-in-truffle-part-2-using-truffle-and-graal/

**Antlr4 Tutorial**
https://tomassetti.me/antlr-mega-tutorial/#lexers-and-parser
https://habr.com/ru/post/341138/

**Настройка idea annotation processor**
https://stackoverflow.com/questions/43999714/intellij-maven-default-annotation-processors-configuration-getting-lost
https://medium.com/@komamitsu/how-to-run-simplelanguage-built-using-truffle-for-the-graalvm-on-intellij-26b08dad9238

