package edu.mit.to_components_share_memory;

public class Singleton {
    private static Singleton v;
    public String s;
    
    public static Singleton v() {
        if (v == null) { v = new Singleton(); }
        return v;
    }
    
    public Singleton() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1478513711000L;
    public static final String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAANVYa2wURRyfu75r5dryFKEtpWJ4eCu+ElMfQCnSetCGAtHz" +
       "cUx353pb9naX3dn2qC8kMfpFQxQUEm38gDEafMRo9IumxigYjYmG+Ep8xE++" +
       "SOCDaMTX/z+7t6/eSfxok52Zm5n/f/7P3/ynx06ROtsiq01D2zumGTzNSjw9" +
       "rl2d5ntNZqcHM1cPU8tmSp9GbXs7zOXk7pdTZ88dKLQmSX2WzKW6bnDKVUO3" +
       "tzHb0CaYkiGpYLZfY0Wbk9bMOJ2gksNVTcqoNu/NkAtCpJz0ZMoiSCCCBCJI" +
       "QgRpfbALiC5kulPsQwqqc3sPuZckMqTelFE8TpZFmZjUokWPzbDQADg04u+d" +
       "oJQgLlmky9fd1XmWwodWSwefuLP1lRqSypKUqo+gODIIweGQLGkpsuIos+z1" +
       "isKULGnTGVNGmKVSTZ0ScmdJu62O6ZQ7FvONhJOOySxxZmC5Fhl1sxyZG5av" +
       "Xl5lmlL+VZfX6BjouiDQ1dVwE86Dgs0qCGblqczKJLW7VV3hpDNO4evYczNs" +
       "ANKGIuMFwz+qVqcwQdpd32lUH5NGuKXqY7C1znDgFE4WV2WKtjapvJuOsRwn" +
       "i+L7ht0l2NUkDIEknMyPbxOcwEuLY14K+efU1useuUvfrCeFzAqTNZS/EYg6" +
       "YkTbWJ5ZTJeZS9iyKvM4XfDmQ0lCYPP82GZ3z+t3n1m3pmPmhLvn4gp7hkbH" +
       "mcxz8tHROR8v6Vt5bQ2K0WgatorOj2guwn/YW+ktmZB5C3yOuJguL85se+/W" +
       "fc+zn5KkeYDUy4bmFCGO2mSjaKoas25iOrMoZ8oAaWK60ifWB0gDjDOqztzZ" +
       "oXzeZnyA1Gpiqt4Qv8FEeWCBJmqAsarnjfLYpLwgxiWTENIAH2mBrwa+a73+" +
       "Kk6elnbYEO5SYZKOO/pYhjFpI5tgmgFOhGxVLENVRrijqIa0EccbwOAFaQCD" +
       "sg/EN3SmcxgUHV2VRX5IIxBSGuMQ+WslapqSbclSkaq6JOKOKY5UVCEejJxc" +
       "prdzdoFaLAepZ1h7AwZppDD/BzKW0M6tk4kEhMCSOABpkLubDU1hVk4+6Gzo" +
       "P/Ni7oOkn5CehzhZA6em4dR09VPT/qkkkRCHzcPT3ViDSNkNmANo3LJy5I7B" +
       "XQ91g4dL5mQt+Bm3StUvhb4ApQYEFsuQKmTm8OT9O++7PEmSUXRHiWGqGcmH" +
       "EZN97O2JZ3UlvqkHvz/70uP3GEF+R64LD3ZmUyJsdMdtaxkymM1iAftVXfS1" +
       "3Jv39CRJLWAR4C8HtyK0dcTPiMBHbxmKUZc6UDhvWEWq4VIZP5t5wTImgxnh" +
       "9DnYtLv+R3/EBBQofv2I+dTnH/1wpbBkGfBToSt0hPHeEMggs5SAk7bAvdst" +
       "xmDfV4eHHzt06sHbhG9hx/JKB/Zgi5EP3gELPnBizxfffH30ZDKIBw63rDOq" +
       "qXJJ6NL2N/wl4PsLP0QKnMAe7os+D6W6fJgy8eQVgWwAWBqAJgZHzw69aChq" +
       "XqWjGsNg/CN1ydrXfn6k1XW3BjPlaFlzfgbB/EUbyL4P7vy1Q7BJyHhhBvYL" +
       "trkoPDfgvN6y6F6Uo3T/J0uPHKdPAZ4DhtrqFBOwSIQ9iHCgJGyxSrTp2Npa" +
       "bDrtcIxH0yhU2OTkAydPX7jz9FtnhLTRyijs9y3U7HWjyPUCHLaQeA3C88Zy" +
       "j6tzTWznlUCGhfGs30ztAjC7ambr7a3azDk4NgvHylAz2EMWAE8pEkre7rqG" +
       "L99+Z8Guj2tIchNp1gyqbKIi4UgTRDqzC4BZJfPGdUT8TTZC0yrsQWZZyI2i" +
       "ReJXEgRcWR1rNmH1E6Trot+HtNH93/02y1ICZSpc+jH6rHTsycV9N/wk6IN0" +
       "R+qO0mwwhkoxoL3i+eIvye76d5OkIUtaZa8M3Uk1BzMtC6WXXa5NoVSNrEfL" +
       "KLdm6PXhbEkcakLHxoEmuARgjLtx3ByLirlo5U740MDM628NR0WCiME6QdIl" +
       "2uXYrHB9wkmDaakTkLyQ+baoeEs+d+HDdm9wi9cPhrhzkpgQCOfCHLZXYLPe" +
       "5XFN1Rjp9c+4AGfnwVcH35TX76mgwWBlDRI4vDQmc7PHx/T68ajMttg9H54r" +
       "IvbRVWm34o3pcfO/6OEudWGzxT9d/NV72Xml118WOj2UDwQzdmm1elfU6kf3" +
       "H5xWhp5Z61al7dEash+eSC98+ueH6cPfvl+hbGjihnmZhtVQ6Ey871dVz8Et" +
       "4l0QJMLx/T8u3n5DYdd/uOo7YwrFWT635dj7N62QH02SGj8tZr1YokS90WRo" +
       "thg8sfTtkZRY6rtgCZp2qVfYHvH6w+GACpw8Ox9ENGHTHwupNo/Tw16/L+7U" +
       "ytcD+5c1EW05P4eCsNt1vvSJQCy42i//8JJbNOuh6z7O5BenU40Lp3d8Jiog" +
       "/wHVBAVG3tG0MNyExvWmxfKqkLfJBR9TdPDi6T5/YQoPx+qLQpWiy24PAJHH" +
       "jpMaaMOLOAWLOHTMCrnrwmwpEU0u35zt5zNnKB+XR5JD/GehHMiO+7+FnPzS" +
       "9ODWu85c84xbtskanZoSL1F4WLvFoZ8My6pyK/Oq37zy3JyXmy5JejERKRtj" +
       "snVWrov6iyYXlczUGwtfve7Z6a9FOfcPe40FuPIRAAA=");
}
