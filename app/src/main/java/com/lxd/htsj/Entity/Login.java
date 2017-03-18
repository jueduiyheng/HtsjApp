package com.lxd.htsj.Entity;

import java.util.List;

/**
 * Created by suixiang on 2017/3/3.
 */

public class Login {

    /**
     * msg : 查询成功
     * data : {"title":"遗失的世界","tag":"动作 / 科幻","act":"詹妮弗·奥黛尔 威尔·斯诺 拉塞尔·布雷克利","year":"1999","rating":null,"area":"美国","dir":"理查德·富兰克林","desc":"本剧取材于制造出福尔摩斯这个人物形象的英国著名作家亚瑟.柯南道尔的经典小说。故事讲述的是在一块未开发的土地上遭遇恐龙的危险经历。 一名孤独的探险家死去了，他那破旧的、包有皮边的笔记本便成为因时间而被淡忘了的史前高原探险活动的惟一的线索。 在伦敦，爱德华·查林杰教授召集了擅长不同领域的冒险家，组建了一支探险队，决心证实遗失的世界的存在，在地图上未标明的丛林中探险。 在亚马逊丛林一片被时间遗忘的高原土地上，科学探险队的几位成员在寻找离开高原的路径。他们必须防御来自原始部落猎人们的袭击。他们在野外的高原上遇阻，无法返回，而这里又是一个令人害怕的世界，时常出没一些史前的食肉动物、原始的猿人、奇特的植物和吸血的蝙蝠。为了生存，这群命运不济的人必须团结起来，拋弃个人之间的喜好和偏见，随时准备应付任何可能突发的情况。在野性丛林美女维罗尼卡的帮助下，手中只有几只猎枪的他们用智能一次又一次摆脱了死亡的威胁。","cover":"http://p6.qhimg.com/t0160a8a6f5b768034a.jpg","vdo_status":"play","playlinks":{"tudou":"http://www.tudou.com/programs/view/KVeyWojke1M/?tpa=dW5pb25faWQ9MTAyMjEzXzEwMDAwMV8wMV8wMQ"},"video_rec":[{"cover":"http://p7.qhimg.com/t01513514907831e055.jpg","detail_url":"http://www.360kan.com/tv/Q4Frc3GoRmbuMX.html","title":"浩劫余生 第一季"},{"cover":"http://p2.qhimg.com/t01f969930fae67d1ec.jpg","detail_url":"http://www.360kan.com/tv/PrVtaX7kRzXsMn.html","title":"神盾局特工 第2季"},{"cover":"http://p6.qhimg.com/d/_hao360/video/img200909_18_145544738.jpg","detail_url":"http://www.360kan.com/tv/QrFob33oRGboMX.html","title":"新绿野仙踪之铁皮人"}],"act_s":[{"name":"詹妮弗·奥黛尔","url":"http://baike.so.com/doc/5907024-6119928.html","image":"http://p2.qhmsg.com/dmsmty/120_110_100/t0154caf60f6fa2dc56.jpg"},{"name":"威尔·斯诺","url":"http://baike.so.com/doc/204403-216173.html","image":"http://p8.qhmsg.com/dmsmty/120_110_100/t018d2ce8920050594f.jpg"},{"name":"拉塞尔·布雷克利","url":"http://baike.so.com/doc/1057636-1118829.html","image":"http://p2.qhmsg.com/dmsmty/120_110_100/t01aa727c49da3edc79.jpg"}]}
     * code : 1
     */

    private String msg;
    private DataBean data;
    private String code;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public static class DataBean {
        /**
         * title : 遗失的世界
         * tag : 动作 / 科幻
         * act : 詹妮弗·奥黛尔 威尔·斯诺 拉塞尔·布雷克利
         * year : 1999
         * rating : null
         * area : 美国
         * dir : 理查德·富兰克林
         * desc : 本剧取材于制造出福尔摩斯这个人物形象的英国著名作家亚瑟.柯南道尔的经典小说。故事讲述的是在一块未开发的土地上遭遇恐龙的危险经历。 一名孤独的探险家死去了，他那破旧的、包有皮边的笔记本便成为因时间而被淡忘了的史前高原探险活动的惟一的线索。 在伦敦，爱德华·查林杰教授召集了擅长不同领域的冒险家，组建了一支探险队，决心证实遗失的世界的存在，在地图上未标明的丛林中探险。 在亚马逊丛林一片被时间遗忘的高原土地上，科学探险队的几位成员在寻找离开高原的路径。他们必须防御来自原始部落猎人们的袭击。他们在野外的高原上遇阻，无法返回，而这里又是一个令人害怕的世界，时常出没一些史前的食肉动物、原始的猿人、奇特的植物和吸血的蝙蝠。为了生存，这群命运不济的人必须团结起来，拋弃个人之间的喜好和偏见，随时准备应付任何可能突发的情况。在野性丛林美女维罗尼卡的帮助下，手中只有几只猎枪的他们用智能一次又一次摆脱了死亡的威胁。
         * cover : http://p6.qhimg.com/t0160a8a6f5b768034a.jpg
         * vdo_status : play
         * playlinks : {"tudou":"http://www.tudou.com/programs/view/KVeyWojke1M/?tpa=dW5pb25faWQ9MTAyMjEzXzEwMDAwMV8wMV8wMQ"}
         * video_rec : [{"cover":"http://p7.qhimg.com/t01513514907831e055.jpg","detail_url":"http://www.360kan.com/tv/Q4Frc3GoRmbuMX.html","title":"浩劫余生 第一季"},{"cover":"http://p2.qhimg.com/t01f969930fae67d1ec.jpg","detail_url":"http://www.360kan.com/tv/PrVtaX7kRzXsMn.html","title":"神盾局特工 第2季"},{"cover":"http://p6.qhimg.com/d/_hao360/video/img200909_18_145544738.jpg","detail_url":"http://www.360kan.com/tv/QrFob33oRGboMX.html","title":"新绿野仙踪之铁皮人"}]
         * act_s : [{"name":"詹妮弗·奥黛尔","url":"http://baike.so.com/doc/5907024-6119928.html","image":"http://p2.qhmsg.com/dmsmty/120_110_100/t0154caf60f6fa2dc56.jpg"},{"name":"威尔·斯诺","url":"http://baike.so.com/doc/204403-216173.html","image":"http://p8.qhmsg.com/dmsmty/120_110_100/t018d2ce8920050594f.jpg"},{"name":"拉塞尔·布雷克利","url":"http://baike.so.com/doc/1057636-1118829.html","image":"http://p2.qhmsg.com/dmsmty/120_110_100/t01aa727c49da3edc79.jpg"}]
         */

        private String title;
        private String tag;
        private String act;
        private String year;
        private Object rating;
        private String area;
        private String dir;
        private String desc;
        private String cover;
        private String vdo_status;
        private PlaylinksBean playlinks;
        private List<VideoRecBean> video_rec;
        private List<ActSBean> act_s;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getAct() {
            return act;
        }

        public void setAct(String act) {
            this.act = act;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public Object getRating() {
            return rating;
        }

        public void setRating(Object rating) {
            this.rating = rating;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getDir() {
            return dir;
        }

        public void setDir(String dir) {
            this.dir = dir;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getVdo_status() {
            return vdo_status;
        }

        public void setVdo_status(String vdo_status) {
            this.vdo_status = vdo_status;
        }

        public PlaylinksBean getPlaylinks() {
            return playlinks;
        }

        public void setPlaylinks(PlaylinksBean playlinks) {
            this.playlinks = playlinks;
        }

        public List<VideoRecBean> getVideo_rec() {
            return video_rec;
        }

        public void setVideo_rec(List<VideoRecBean> video_rec) {
            this.video_rec = video_rec;
        }

        public List<ActSBean> getAct_s() {
            return act_s;
        }

        public void setAct_s(List<ActSBean> act_s) {
            this.act_s = act_s;
        }

        public static class PlaylinksBean {
            /**
             * tudou : http://www.tudou.com/programs/view/KVeyWojke1M/?tpa=dW5pb25faWQ9MTAyMjEzXzEwMDAwMV8wMV8wMQ
             */

            private String tudou;

            public String getTudou() {
                return tudou;
            }

            public void setTudou(String tudou) {
                this.tudou = tudou;
            }
        }

        public static class VideoRecBean {
            /**
             * cover : http://p7.qhimg.com/t01513514907831e055.jpg
             * detail_url : http://www.360kan.com/tv/Q4Frc3GoRmbuMX.html
             * title : 浩劫余生 第一季
             */

            private String cover;
            private String detail_url;
            private String title;

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public String getDetail_url() {
                return detail_url;
            }

            public void setDetail_url(String detail_url) {
                this.detail_url = detail_url;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }

        public static class ActSBean {
            /**
             * name : 詹妮弗·奥黛尔
             * url : http://baike.so.com/doc/5907024-6119928.html
             * image : http://p2.qhmsg.com/dmsmty/120_110_100/t0154caf60f6fa2dc56.jpg
             */

            private String name;
            private String url;
            private String image;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }
        }
    }
}

