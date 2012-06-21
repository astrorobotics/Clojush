;; korns_regression_p12.clj
;; a symbolic regression problem based on Michael Korns's draft chapter from GPTP11
;; Lee Spector, lspector@hampshire.edu, 2011

(ns clojush.examples.korns-regression-p12 
  (:use [clojush.clojush]
        [clojush.pushstate]
        [clojure.math.numeric-tower]))

(defn generate-data 
  [rows] ;; korns uses 10000! But we won't :-)
  ;; There are five columns of data, only two of which are actually used in the
  ;; target formula. We also compute the answers here and store them as the 
  ;; sixth column.
  (println "(def data '(")
  (doall
    (repeatedly rows
                (fn []
                  (let [inputs (repeatedly 5 #(- (* (rand) 100) 50))]
                    (println (concat inputs 
                                     (list (- 2.0 
                                              (* 2.1 
                                                 (Math/cos (* 9.8 (nth inputs 0)))
                                                 (Math/sin (* 1.3 (nth inputs 4))))))))))))
  (println "))"))

;(generate-data 100)
 
(def data '(
(-31.73117325008007 17.773604522468673 31.925706547733043 36.416289048313004 32.49069406728982 -0.06562138816756669)
(-28.787483635591528 28.726707225743425 26.12958469185277 30.40946153838358 -31.931077640882854 0.943614754386817)
(-39.8366746305788 5.898328014623608 -40.63986958492947 31.715529833544238 49.81749645034415 0.6910427652174165)
(-47.85199599535973 1.5436755717853856 -31.987984681023818 -12.861725463664321 -23.763577863688255 2.690814122278602)
(31.23869963297487 3.076901113909379 -41.7700962255994 -6.661334311364364 -37.998896867086565 2.2645749940307467)
(-10.811510860782079 40.591805938102084 23.329861676334474 -32.063106871301244 15.561069731693678 0.65688802838761)
(-9.524262005642484 16.320108256485682 3.0746105623062903 -45.409712094312326 -44.47087080936873 3.2284561595629473)
(-34.09380385749223 -14.069755794726078 46.13418939708963 -47.477410187487415 -28.260187644827095 1.2352872079989745)
(12.548972844317007 -27.505882238082247 -39.7865253711626 39.67216113110828 10.624427371566156 3.784877923163209)
(4.982329186256621 -9.223715545260802 -37.48001539763136 49.73757242334294 9.310806815306684 2.1234099317121493)
(19.73459475194936 7.408242619438624 -21.67624918529999 -18.491582013234776 -26.041883289225375 2.2578697920083077)
(46.67976828950174 -33.33219404500897 48.67125532683204 0.042377625859188583 8.522437891953501 2.73718893044257)
(-2.956380107975164 9.57358573409659 -38.7325227322696 -9.250500818008419 -42.94420731772254 3.0621431461530664)
(9.014572528665418 40.33615969274575 -23.42110068305584 -39.69236519061404 36.74851063581666 3.1797871603104886)
(-42.77948167696951 14.79260713822994 39.711000851232086 16.944038509838407 46.700377964804616 1.7083381050035313)
(-21.682973136099083 33.06992642034811 7.340398343851753 -21.444543828436803 -4.949160852768266 2.133061228955215)
(8.011447695825503 -41.38349534933654 44.87719599097984 -47.32330665662276 -46.09664468482633 2.489554634849486)
(-6.038780592178952 -16.404843481921738 15.22837097892615 2.0900737603696484 -43.56911628795428 1.8331335269807465)
(-44.93330485524494 -46.65482503500237 22.59422656297673 37.402845125955295 39.45761138548599 0.4412564284285858)
(-17.569529618978883 -14.62708047783822 43.28132443393797 -23.354691909791146 23.34144809863274 0.48442538212410424)
(-32.71591060349893 -20.415323910939232 27.50496007561233 48.772334895767244 32.10974755083211 3.622823674824528)
(31.640707592971722 -4.306937122408115 -44.846538657770786 10.299318161368795 -0.6605882703033643 1.0607502344354705)
(12.421638466150917 4.6737024105030684 -42.462301320912196 -0.259902138406062 -46.77969068977548 3.3324819177886975)
(14.944010253704661 -23.190967356623528 -14.19741577071106 25.31231729600448 34.854894023152355 2.732067600234752)
(47.31865745881005 42.10975787136164 36.98451913077213 34.34084247684717 15.452030998885888 1.341963782068663)
(9.171470077620484 36.210236819556656 -46.95011042827024 -32.109100269022136 -43.25262404094048 2.223592227192059)
(-15.212186957754689 -1.6733860868933448 25.073332889963396 -26.4009802262446 16.386570914918124 2.1944300826525933)
(-43.547924707542094 -35.62431210237973 -33.82091058862328 12.145815797537118 -17.255677075840026 1.2074247497051673)
(6.7109665612377825 -38.01158476245272 15.851431751978879 -34.09173231915764 -22.32058868881318 3.3897604176185534)
(-5.321013275695442 2.218472256276783 19.93385439300772 -15.026367522140504 7.45387977457024 1.8322333949636698)
(6.437156300948658 42.876674626991544 37.431921723318666 48.912650576423644 20.8934576803087 0.1760129327420361)
(-3.984756507851003 -32.050145835268886 -48.7865984273717 -34.145497076446915 -0.8356147664592157 2.404258445775438)
(12.401660463352059 -25.729572732583595 44.91280697093738 8.334299182231419 39.789252591682526 3.1525005153928407)
(-28.32107222760132 3.112350898793636 40.460023310435545 25.028231013826783 -15.844003013039519 2.962746357382205)
(15.933359611402338 36.58620548536061 5.0965569799345545 -5.490274891906807 -49.30843087660024 3.1943921115957084)
(9.677199913358649 -38.28698262137815 -15.504099882041508 -41.58830655350256 6.13271894978309 0.26585823974076717)
(29.27899508004724 18.39448129702909 -26.136344965479687 21.12437235290831 35.5084847746555 2.858848328906249)
(40.73563640756922 24.20412990669554 47.02861089750719 43.987667601057765 16.327806666148135 3.4170280480017734)
(-27.45523247352708 1.5167606875308834 -17.153198959267243 -40.41204280773335 -48.227545248571346 1.8748084441065276)
(-22.727056185688465 11.793558036642949 -2.8532711791729426 -23.924201132475943 -21.154095459600676 0.6103052458683655)
(0.9483728261683524 -17.20100939280804 -47.11401016199339 -36.199164310887845 -30.761239038672482 0.43427037007045177)
(37.092833138495536 -43.680922648978004 -14.877458199378324 -42.44905536147701 15.197790908760496 0.9908817396184979)
(-35.28940631934272 39.7313396600988 -7.596396860627117 16.165657538624046 9.462368783655108 2.5319535408899023)
(-35.991628067597034 29.599880890112857 34.29498983874984 30.175301557035297 -18.61297800590407 0.8963557037925007)
(-45.86974830476127 19.03298462584317 -18.079241140597134 -0.6476078419326186 -47.459750034634084 3.831082239781523)
(-46.30387448738807 -5.492869972440019 -26.39907538385444 -32.95657368121873 -14.736383439043486 2.1152387570492537)
(40.727067385616934 5.6473655132738045 -13.14864645451501 37.59529025239007 30.824742468826543 3.444782546575399)
(16.826490000361034 31.50888500494476 18.648319715034717 13.801423348457106 46.42211127550566 2.043698388012036)
(33.46428817499434 -11.385248921919619 32.68157871754728 -45.43390782926045 32.670251872336024 2.711719650923245)
(-9.62550310579583 -49.50941005569928 -28.414807589612423 -45.29678267564137 -43.74389246316165 2.6551674018928972)
(36.44907017540285 24.633794091292017 -44.295145674735494 -4.179729534972175 -22.2322755562952 1.2733636447868766)
(-10.264353421515814 -17.609077693200348 38.228678581830806 -38.56944684298465 -37.2320300212287 -0.006891491650100612)
(13.439170141134305 49.73354683407872 -47.51687300318931 16.45639569683641 19.759308068325282 0.9270464784085657)
(-28.0793116044593 -19.403449739803136 12.109386740325675 5.464531631202874 29.561755297358232 1.601849027848285)
(35.056675912757356 -35.39407826169614 -31.19455065456842 38.27891232194439 -40.16801588808858 1.1542644789287044)
(17.060406166158444 -47.106316268697455 1.6978011657794028 35.002501286819125 -32.37610929837358 3.539165279712792)
(39.73382862257645 25.36239527067835 28.585992524046105 5.040907294926512 -22.101154594286054 1.0857809136093335)
(-9.592058171413441 3.676592272659839 -48.133715131874496 24.125375970801727 23.83585979918935 2.8478764626257003)
(-30.18503768844868 -15.343435495072697 22.17188686700655 -25.792854222500917 -25.36208851989733 3.838990626724212)
(-1.0142754671000205 38.47393612257028 -48.331562157331234 42.10939641780767 13.79510533572251 0.5505771683143119)
(23.447256348816254 19.44760525548962 -22.986338123082106 -35.6274211854857 -30.269195098308955 0.11225565524644598)
(30.303355963752196 -28.104770635394672 16.16616943714486 -5.771736281031238 -14.114003919402776 2.0931076225637755)
(-27.740673386314462 42.67247148016999 -20.502061243284707 -40.4358105346665 -21.399741429284646 1.8979920748819556)
(49.80039041516248 -28.142622233281543 -36.004867788114105 -10.295872104706973 -3.604144848894272 2.957878743308939)
(48.51046536057386 -36.43668550658373 20.676259617781525 -43.976650461305 34.07111837447964 2.3343132301831915)
(28.785615313471595 -38.72751864030035 -11.364766251814643 -31.950857016736055 4.8781757085261575 1.9019309237495656)
(-24.6325343265013 42.419988059127306 -0.8197839459610492 19.903141039831098 -19.227877365092006 2.250257648386676)
(-14.094315064264919 9.923354132045922 -10.738985701173675 -9.884009673322616 -21.694867677978557 2.1481542179246658)
(-44.98437621708392 -17.232960798483695 38.139504141458175 22.124291480853515 31.665302772642647 2.3478630537027114)
(8.147652306775612 -31.50515650321988 6.2157459899207765 -14.218966495705907 30.51572667082239 2.5039014369139654)
(4.033087402378868 39.744119130153024 -1.4239971389244346 -8.769007801425147 -21.440828918464717 1.793623573143703)
(-2.0594625212851128 -9.047497657245962 11.524641990894871 -34.834824133431574 49.058358116794224 1.5996425617816006)
(29.263705892946717 -33.635177567165364 -3.4936878741403135 8.60254363198191 15.36583717394491 3.179294504682338)
(-7.737661687350048 35.762866568882885 -28.309745276098475 -3.6846202132833312 49.063581252187234 0.44705297144528267)
(23.53533770330813 7.310316990718405 34.63232546408814 -9.74967924067166 -4.451184448206405 2.2579620140067393)
(-40.715534336559266 38.74188010226503 8.863685100495246 38.7966675284554 -12.106655611603578 2.064407905793022)
(-34.976508435171674 16.89227429567663 29.632375255323993 3.4154415800789337 -32.162591225051806 3.6360329543491288)
(-15.187941756839265 -23.67759609548702 -11.762689927345512 -8.03456267793512 14.938303219305126 2.4245139016814203)
(-29.298225786787846 -22.271510424556872 -26.906072556526983 47.34748861963848 38.82800212138592 2.143762365884124)
(-28.265144329521895 36.28346034037942 0.3497978038359193 -31.092066230146408 -21.670888623457085 2.183914184536481)
(-40.18889211418577 28.84042191874137 -13.724100227863467 49.36742114091237 2.337512486984096 2.0876458812206646)
(43.330578268654236 39.83057054928729 -46.56372774081958 -24.957518573912463 -29.943166938055366 0.2888165654112227)
(-37.908261740836366 45.93383318826521 -22.810826649645954 48.28989360691594 -34.08280049265315 2.470995651645983)
(38.31521150621555 3.5183720617807595 -45.188203228968185 44.9238041734705 38.94123049525042 1.9494342764030552)
(-25.05926970526665 17.502966424817487 -48.21435318983717 36.50539810250382 40.18628933035785 0.3418139139129952)
(30.078377778837677 38.836285820369 23.67399001385472 45.38700778818141 8.234635246749 3.7240300681921537)
(-41.2192597307398 13.35929981584546 -28.990644021116562 33.81746608472096 39.827025474115345 2.526878183198779)
(-17.043776443189543 -8.879430317154494 18.091793634975673 -30.824254401756257 -7.092434359527346 1.6306839643842008)
(18.66342484899907 -22.205811010606524 41.56032761709642 -34.87645456469682 -37.769091932137854 0.5104965143836813)
(-41.62981869624186 -44.59077260281372 -25.933769107172978 34.77350548944035 -42.35348139478427 0.10176101382329739)
(-31.794496998996312 -1.2803501615850337 22.738253549443883 0.16120645998971384 -45.25208271418427 0.6558227705931525)
(7.201617206785862 45.330113930232855 -12.528300128937033 47.27173635276199 -2.5666020451249665 1.955338032441037)
(7.902627284076779 2.984397018570384 -25.233752024951894 -2.9315087304523786 -19.073806302095697 2.3184448160148343)
(-18.80386956614104 -39.67007149461402 33.79199600092778 16.54877781502377 -39.2888959547591 1.2777514397196823)
(-19.966853126166573 23.137167211322335 48.455198409051036 27.994304759894376 34.51210897217 0.986482978899299)
(-14.87409321458101 7.547585040098092 24.545106484103243 35.396747275803676 -6.674863393395157 2.4462665463531392)
(25.91099966781543 34.022466504014005 -37.320911629164115 -19.678894966824977 -5.405392111485163 0.7812866365484543)
(-12.174297475410576 6.257611467747715 -27.85113295824887 -13.069785670097353 27.73257330415116 4.088456444860952)
(-34.85307787087167 0.874325803298035 -41.57363973004124 42.41896125202112 41.2211036878348 1.7580812583172118)
(49.31138524413225 -13.28240227764207 -48.96778867622914 30.862851153191855 14.766900577232818 1.391843599099651)
))

;; alternative data set, in range -0.5 to 0.5
#_(def data '(
(0.4625799583897293 0.09499965519281461 0.13388024180999736 -0.18812902728906655 0.490877105042577 2.222860494990349)
(-0.25710236307732803 -0.1803039346503883 0.059207397950865936 -0.39435586145406243 -0.39242782290811173 1.1665885238907319)
(0.3284131647620443 0.4922165296594241 0.3313241879602159 0.3203401207414246 -0.41800941745965137 0.9173799764799262)
(-0.07806448830895352 0.02395247952852486 0.35204526475590203 -0.2773461488947421 -0.3400634499592351 2.648089926409969)
(0.4402591885838302 -0.14049573870961263 -0.4214714850586646 -0.3811029460523834 0.4442015074130665 2.4441523079474)
(-0.21913004594170105 0.4946232042850398 0.07030542070896051 -0.019161927742538443 0.39893705968223414 2.5675585322698726)
(0.22987679525406413 0.4624097625277763 -0.4031262582970211 -0.22010873286699129 -0.08897750444934338 1.8472252397037356)
(-0.34438264416280706 0.4678654206252707 0.4647295576781073 0.35531128666844947 0.16790491829035592 2.4424234612079756)
(0.10399502147719819 -0.4584437950208332 0.4266759169176979 -0.46059905386754996 -0.3505211246358674 2.4843361244920747)
(-0.2408148725100029 0.4737058560576529 -0.27684699648007727 -0.03490269819584835 -0.3440436555858122 1.3553493415230986)
(0.31284265113710297 0.4881947176941679 0.48899203879381115 -0.227599660262924 -0.3335059164957709 1.120314714812464)
(0.18137822686951754 0.20779337513836738 -0.1076389562029283 0.44330483608732807 -0.1639600817883642 1.908825761077066)
(-0.06169748108829798 -0.0855854127961343 -0.24338994550796433 -0.4615813514805214 -0.4806303665853544 3.0106136851353344)
(0.3938975785934977 0.11713773022570495 0.16684696053645864 0.44427093095590786 0.01558500340127289 2.0320240760751376)
(-0.1926855684961052 0.10408795747168187 -0.07419684580721575 0.25803475509696616 0.047068240448726484 2.0400932648703187)
(0.2897914656533426 0.37947752069189356 0.2928424288952781 0.19481190118216107 0.02789503112962255 2.072699297076298)
(-0.16539079578395854 -0.2744743397241288 -0.10767208216836455 0.29289661075698226 -0.1612375326043537 1.9781463811513977)
(0.12948532948276215 -0.241433470931689 -0.11072218662859057 0.007925883320580418 0.4504663121276026 1.6549558642877027)
(-0.035092933115212444 -0.2900425363120064 0.4929560027373656 0.2661673074205454 -0.21677894897651828 2.549806821717783)
(-0.48749254499842 0.2822415326725035 -0.4258736323015422 -0.011884082665024831 0.0859640466885736 1.9847792570586105)
(0.4412049027275069 0.2507347000051928 -0.18397370193005047 0.41641929004171074 0.10117150360985083 2.1043433050227724)
(-0.42479212916049913 0.036359004880282875 0.4761791907104411 0.2533011983565616 0.2445707635264276 2.342815584567224)
(-0.4263125829451754 -0.44087352001297697 0.1776907231794539 0.11918851723211565 0.035029432632976754 2.048700413812583)
(-0.33597273986593157 -0.35658018144740966 -0.4668977411111285 0.4425325697858924 0.2878730708523115 2.7589488275515563)
(-0.14777224887423124 0.379405768930677 0.44942883932403466 0.13295036792530102 0.4666710036373094 1.8535464216127893)
(0.33812481026508656 0.32591075068913655 -0.34581769741502333 -0.03697282579648842 -0.4474621883316521 0.8631952745221763)
(0.041619529916983256 0.07738794502153734 -0.0201260578655712 -0.22039636461440326 -0.1572751845801944 2.3913992596681766)
(-0.49554336000299437 0.29518614432992973 -0.45886226067250735 -0.17588492100761577 -0.011963753279333966 2.0046846940618512)
(-0.4420420466012204 0.0846054153318373 0.131006159310883 0.006185670267488175 -0.07522845862991767 1.9238722973291487)
(0.02587724939335534 -0.41068460683593844 -0.40345621347520055 0.3073971548298676 0.3910177906790008 1.0105930592496186)
(-0.23956315248182058 -0.48008179049235833 0.024423976852896545 0.40015615183610764 -0.356407151637785 1.3419931384940642)
(0.21479909394748642 0.26808528631567863 -0.2562872638575334 -0.49227390976867724 -0.022845229109487386 1.9682482343111116)
(-0.05314512645778657 0.28973361016146726 -0.37506468311884256 -0.2460329524932341 0.1450566530221158 1.658533649944874)
(0.13081003980446215 -0.0012532320476829062 0.1743167442879079 -0.3473572596969593 -0.3699621433407565 2.2767411714614365)
(-0.46694708390633977 -0.041570096258738753 -0.23854058041036186 -0.34230286837593904 0.471338535132498 2.164113909873482)
(-0.3570515079292108 -0.20126484714128845 -0.4761897813663726 0.350853943552354 -0.36021058496729286 1.112103068940324)
(-0.32581231376094244 0.20646146495542617 0.16268352754451954 0.006308465146524056 0.05406253752742196 2.147274735511799)
(0.35173996667658347 -0.11380286414602381 -0.053913731169180856 -0.3564214872071607 0.17839179263495042 2.4603133110938207)
(0.07516135814239333 -0.017494046328842217 0.4586699332577193 -0.14125397706616427 -0.2871742616613481 2.567356176536528)
(-0.04860703460758464 -0.10141992475529726 0.16720447430697538 0.12458916601589443 0.4443393604432644 0.980953176897474)
(-0.10722686547477878 0.18856206277654874 0.3393900685145842 0.10093661249986052 0.3887973816541894 1.4947970878470014)
(-0.33934870189022537 -0.07524685757796634 0.1959923059437364 -0.02785464684276784 0.08928086156367887 2.239083673741899)
(-0.014535261716824732 0.29690759780854825 0.46482144142634974 0.1181646628188393 -0.2878621129042216 2.759874438961039)
(0.3767441459320652 -0.0637591760007209 -0.23748539382738632 -0.4065332813339462 -0.33988934545860505 1.234669474452474)
(-0.3217513201683333 0.02219677493250294 0.1647598623605272 -0.34814937803239354 0.34546130622571947 2.91166380947419)
(0.07882698573017133 -0.044619461231100166 0.2526145121480612 -0.35720367953698573 -0.249091092037378 2.4785389734796026)
(0.11901090335975106 -0.3992486326725865 -0.34602805753865384 0.13209359495706152 0.08319681013412372 1.910788337764337)
(0.29655607395216665 0.14792026671444525 0.3698669388310931 0.4384183425029491 -0.03723978034286923 1.9011764590783289)
(-0.02552714780076548 0.35544684453749154 0.2019705246794835 -0.32574396388946814 -0.03365825112900689 2.088998299276424)
(-0.30960033687965927 -0.4617721370904775 -0.3496052724495964 -0.3986676818152698 -0.32853854255839776 1.1351327536343137)
(-0.005594973197947883 -0.25519859438002457 0.04688882831002594 0.19227570919778225 0.31971543777804123 1.1533647450568882)
(-0.30949886233057555 0.10848805400953054 0.39923711069086754 -0.024131661187380526 -0.23774823535952583 1.3649880808513684)
(0.03405909245856187 -0.34164429057540036 -0.48186568599768753 -0.49666917508102415 0.08852311939091517 1.7721729524388898)
(-0.10896584006689125 0.12874767322471425 0.4306252976637591 0.3057098331727607 -0.3811241758596948 2.4812337419747013)
(-0.28179616345401926 0.17972492167316978 -0.15067819836107443 0.12111898396551812 0.17504866950229847 2.439974231846149)
(0.3808207805956433 -0.029718099377029294 -0.04698120765430924 -0.45895439748950717 -0.3334371074995951 1.267295419504443)
(-0.3652869941873944 -0.3005252102852064 0.11614552406644874 -0.3953680717392354 -0.4850364522977141 0.8788604286199488)
(0.24542885064481101 -0.2435260127226846 0.020631609220066127 0.1855060622861725 0.03303472028658361 2.0667971891479198)
(-0.08141181391337438 0.13101024724397548 0.046200330382122234 -0.2546731640703823 0.32454676262723725 1.3995268846800872)
(0.14107103781493746 -0.29267360263131925 -0.392907020066525 0.47487297412136087 0.4797326490160312 1.7704294153498412)
(0.31395758019844555 0.025881463190609022 -0.3797177989828673 -0.35944706442934204 -0.4383436294211803 0.8694221579752164)
(-0.39044956142588927 0.21808279358454608 -0.3223697689718701 -0.038858433553776495 -0.30850667509488927 1.365014340158791)
(0.345448989414046 -0.23465144179251385 0.24648810582021952 0.3706510183085393 0.019303317552729515 2.0511341920381767)
(-0.1274659439601381 -0.31041454551619907 -0.2693522252500953 -0.11866486919986363 -0.4755580830632685 2.3847540472136717)
(0.4829944470733514 0.3408650488908992 0.24672110972393224 -0.16990519324830178 0.28400664711134793 1.984119353795134)
(0.36199280250556787 0.08640208969311736 0.43784460755886045 0.4746240686372728 -0.42042414264836214 0.9972374243327753)
(0.11531041712183832 -0.1513680104556152 -0.31465852613594925 0.47129823426258954 -0.20726954334672154 2.238491622324691)
(-0.435731434728878 -0.34497271968076304 -0.022774303226017922 -0.2939857686237427 -0.12283071127511114 1.8571062442509074)
(-0.4451365200919335 -0.013047240322596299 -0.494836678933502 -0.28168697192797976 0.49121855015483584 2.429273567002318)
(-0.3164223704058533 0.28332660694403944 -0.12818787493912454 0.02049189777810112 -0.20834554271326966 1.438609686825417)
(0.05705372403188114 0.03732186126480175 0.1583822031003106 0.46474916495619467 -0.20981829155853216 2.4795778566524915)
(-0.32437615135999354 -0.4533039604454292 0.01795172941029277 0.2265223433905309 0.3080675184967069 2.818152608503577)
(0.15272735553260075 -0.03832574195954519 -0.3509433127889824 -0.042843402515702955 0.11940233428023861 1.9759749148342636)
(-0.1747095407886594 -0.4328683588369461 -0.2865819771958499 0.15879843224005774 0.07264970186440867 2.0279010924169616)
(0.248193717732477 -0.007206680988949499 0.18730997918228354 0.006223683046852946 -0.043117277710144064 1.910725730864788)
(-0.09085701766974319 -0.2623524879960919 -0.06737768169072422 -0.2581516240422961 0.32805694851769984 1.4535035389376785)
(0.051021415409632453 0.019440238877364124 -0.3805586191890101 -0.4089849385621732 -0.34772526330531617 2.8049921411683405)
(0.21187306082759683 0.043469652926113045 -0.3969567358661795 -0.358605695343329 0.29726851250493336 2.3833181331597926)
(-0.3785007677976777 -0.03763683224669112 -0.10325696256571393 -0.2932456612725044 0.14071889749887367 2.3220962030697114)
(0.07713336026357942 -0.12147941591618938 -0.0746886077680895 0.10017637075187846 -0.23776655941126723 2.4648343071229304)
(-0.2546265947026827 0.44513681704995023 0.11123282510672106 -0.3618576888840538 0.052739491972866315 2.1148549390527687)
(0.041868978392116896 -0.275628154426096 -0.23568545285365972 0.3884270420587371 -0.2207779608123419 2.545137741730863)
(0.4680378490964604 0.3310600035988379 -0.08090962750427855 -0.44519493851045744 0.14396810357185885 2.048955311783439)
(-0.09321682921281405 -0.029319538000717404 0.18837680588685868 -0.2864786441411974 -0.30845938568302733 2.5008073241979307)
(0.4466116975488159 0.023513744032825912 0.43079567059614043 0.46322642873645015 0.09930005163906275 2.0890301481565205)
(-0.2353539175362067 0.23086630860468216 0.419296791905992 0.4138926430231581 -0.19635769824299476 1.6441542901096324)
(-0.2347356095288936 -0.08520302315313899 0.13742207645438076 -0.39639999720128294 -0.10814443161750142 1.8038500850817711)
(0.17655484807927269 0.29228324768046376 -0.19777322892048554 -0.12743267822616156 0.43375735252845615 2.1781985913510185)
(-0.15015541070586957 -0.4268280121916994 0.009952160741237837 -0.4532726610050474 0.10816942494989601 1.9708288319174068)
(0.44089636593249504 -0.03763623149858952 0.13856985735846195 0.2172373115072067 0.1831434948052727 2.1890312844430837)
(-0.482438607655823 0.43845909445043485 0.2257194593130386 -0.325197109556569 0.17584741784923408 1.992619491315513)
(-0.4693122518314392 0.48527600855250075 -0.47206775591720995 0.49638176864444594 0.47020306906131015 2.1360519175094907)
(0.2415076093910652 0.16493158588230372 -0.20589385680637118 -0.22679519446687502 -0.2348929041732043 1.5488782907682626)
(-0.47466021069032993 0.43975008793592874 0.12048224429531795 0.4324216505674118 -0.04855036949866043 1.9919624456278147)
(-0.28832057685055024 -0.27848130172160335 -0.24845044472432587 -0.07608522111492533 -0.12411221044935339 1.6793511054845123)
(-0.32100624564739044 0.44826021022791385 0.22574824639780844 -0.07078022166627218 -0.13383512233992934 1.6364739924035296)
(0.375439384432696 -0.19841165146651307 0.23095420718758686 0.2837115914228042 0.19042639317558996 2.4419553799711546)
(0.048835295127617195 0.06916461629040915 -0.40202281276094154 0.45652375530950395 -0.4717624621968476 3.072881363855888)
(0.06081330595522294 -0.4208558696346746 0.0681237365665458 0.11373381701125818 0.16832435721592753 1.622722536572077)
(0.45573131860585936 -0.3266894109301468 0.41483337191450154 0.03041996389461976 -0.21909743242681057 1.8561725732264986)
))

(define-registered x0 
  (fn [state] (push-item (stack-ref :auxiliary 0 state) :float state)))

(define-registered x1 
  (fn [state] (push-item (stack-ref :auxiliary 1 state) :float state)))

(define-registered x2 
  (fn [state] (push-item (stack-ref :auxiliary 2 state) :float state)))

(define-registered x3 
  (fn [state] (push-item (stack-ref :auxiliary 3 state) :float state)))

(define-registered x4 
  (fn [state] (push-item (stack-ref :auxiliary 4 state) :float state)))

(pushgp 
  :error-function (fn [program]
                    (doall
                      (for [row data]
                        (let [state (run-push program 
                                      (assoc (make-push-state)
                                        :auxiliary
                                        (take 5 row)))
                              top-float (top-item :float state)]
                          (if (number? top-float)
                            (expt (- top-float (nth row 5)) 2)
                            1000)))))
  :atom-generators (list 
                     ;(fn [] (- (* (rand) 100) 50))
                     (fn [] (- (rand) 0.5))
                     'x0
                     ;'x1
                     ;'x2
                     ;'x3
                     'x4
                     'float_div
                     'float_mult
                     'float_add
                     'float_sub
                     'float_sin
                     'float_cos
                     ;'float_tan
                     )
   :max-points 30
   :evalpush-limit 50
   :population-size 500
   :mutation-probability 0.20
   :mutation-max-points 10
   :crossover-probability 0.40
   :simplification-probability 0.1
   :reproduction-simplifications 10
   :gaussian-mutation-probability 0.2
   :gaussian-mutation-per-number-mutation-probability 0.5
   :gaussian-mutation-standard-deviation 0.1
   :tournament-size 1
   :decimation-ratio 0.1
   :decimation-tournament-size 2
   :node-selection-method :size-tournament
   :node-selection-tournament-size 3
   :max-generations 10000)
