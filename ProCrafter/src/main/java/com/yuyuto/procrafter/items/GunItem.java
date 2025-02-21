package com.yuyuto.procrafter.items;

import net.minecraft.client.util.math.Vector3f;
import net.minecraft.world.entity.player.PlayerEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAction;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;
import com.mojang.math.Vector3f;

public class GunItem extends Item {
    private final int damage; // 銃のダメージ
    private final int reloadTime; // リロード時間 (ticks)
    private final int maxAmmo; // 最大弾薬数
    private int ammo; // 現在の弾薬数

    public GunItem(int damage, int reloadTime, int maxAmmo, Item.Properties properties) {
        super(properties);
        this.damage = damage;
        this.reloadTime = reloadTime;
        this.maxAmmo = maxAmmo;
        this.ammo = maxAmmo; // 初期弾薬数は最大弾薬数に設定
    }

    public int getDamage() {
        return damage;
    }

    public int getReloadTime() {
        return reloadTime;
    }

    public int getMaxAmmo() {
        return maxAmmo;
    }

    public int getAmmo() {
        return ammo;
    }

    public void reload() {
        this.ammo = maxAmmo; // リロード処理
    }

    // 発射処理（例えば、弾丸を発射するなど）
    public void fire(Level world, PlayerEntity player) {
        if (ammo > 0) {
            ammo--; // 弾薬を消費
            // 弾丸の発射処理をここで追加
            // 例えば、弾丸をエンティティとして生成し、プレイヤーの方向に発射する
        } else {
            // 弾薬がない場合の処理（リロードの必要性を通知など）
        }
    }

    // アイテム右クリック時の処理
    @Override
    public ItemStack use(Level world, PlayerEntity player, UseAction action) {
        if (!world.isClientSide) {
            fire(world, player); // 発射処理
        }
        return super.use(world, player, action);
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return reloadTime; // リロード時間を設定
    }

    // 銃の発射音やエフェクトなどを追加したい場合
    // 例えば、発射時に音やエフェクトを追加できます
}
